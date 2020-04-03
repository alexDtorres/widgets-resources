import { createElement, CSSProperties, ReactElement, useEffect, useRef, useState } from "react";
import classNames from "classnames";

import googleApiWrapper from "./GoogleApi";
import { Alert } from "@widgets-resources/piw-utils";
import { getDimensions } from "../utils";
import { Marker, SharedProps } from "../../typings";

export interface GoogleMapsProps extends SharedProps {
    scriptsLoaded?: boolean;
    validationMessage?: string;
    mapsToken?: string;
    className?: string;
    mapStyles?: string;
    divStyles?: CSSProperties;

    optionStreetView: boolean;
    mapTypeControl: boolean;
    fullScreenControl: boolean;
    rotateControl: boolean;
}

export const GoogleMap = (props: GoogleMapsProps): ReactElement => {
    const map = useRef<google.maps.Map>();
    const googleMapsRef = useRef<HTMLDivElement>(null);
    const defaultCenterLocation: google.maps.LatLngLiteral = { lat: 51.9066346, lng: 4.4861703 };
    let bounds!: google.maps.LatLngBounds;

    const [markers, setMarkers] = useState<google.maps.Marker[]>([]); //Used to manage and remove markers from the map
    const [validationMessage, setValidationMessage] = useState(props.validationMessage);

    useEffect(() => {
        if (props.scriptsLoaded) {
            createUpdateMap();
        }
    }, []);

    useEffect(() => {
        createUpdateMap();
    }, [props.locations, props.currentLocation]);

    const createUpdateMap = (): void => {
        const mapOptions: google.maps.MapOptions = {
            zoom: props.zoomLevel,
            zoomControl: props.optionZoomControl,
            scrollwheel: props.optionScroll,
            draggable: props.optionDrag,
            streetViewControl: props.optionStreetView,
            mapTypeControl: props.mapTypeControl,
            fullscreenControl: props.fullScreenControl,
            rotateControl: props.rotateControl,
            minZoom: 1,
            maxZoom: 20,
            styles: getMapStyles()
        };
        if (googleMapsRef.current && !map.current) {
            map.current = new google.maps.Map(googleMapsRef.current, mapOptions);
        } else if (map.current) {
            map.current.setOptions(mapOptions);
        }
        addMarkers();
    };

    const addMarkers = (): void => {
        if (props.locations && props.locations.length > 0) {
            markers.forEach(marker => marker.setMap(null));
            setMarkers([]);
            bounds = new google.maps.LatLngBounds();
            setMarkers(
                props.locations.reduce<google.maps.Marker[]>((markerArray, currentLocation) => {
                    const marker = addMarker(currentLocation);
                    if (marker) {
                        markerArray.push(marker);
                    }
                    return markerArray;
                }, [])
            );
        }
        addCurrentLocation();
        updateCamera();
    };

    const addCurrentLocation = () => {
        if (props.currentLocation) {
            const currentLocationMarker = addMarker(props.currentLocation);
            if (currentLocationMarker) {
                markers.push(currentLocationMarker);
            }
        }
    };

    const addMarker = (marker: Marker): google.maps.Marker | undefined => {
        if (map.current) {
            bounds.extend({
                lat: marker.latitude,
                lng: marker.longitude
            });
            const mapMarker = new google.maps.Marker({
                position: {
                    lat: marker.latitude,
                    lng: marker.longitude
                },
                icon: marker.url,
                title: marker.title
            });
            if (marker.title) {
                const infoContent = document.createElement("span");
                infoContent.innerHTML = marker.title || "";
                if (marker.onClick) {
                    infoContent.style.cursor = "pointer";
                    infoContent.onclick = marker.onClick;
                }
                const infoWindow = new google.maps.InfoWindow({
                    content: infoContent
                });
                mapMarker.addListener("click", () => {
                    infoWindow.open(map.current, mapMarker);
                });
            } else {
                if (marker.onClick) {
                    mapMarker.addListener("click", () => {
                        marker.onClick!();
                    });
                } else {
                    mapMarker.setClickable(false);
                }
            }
            mapMarker.setMap(map.current);
            return mapMarker;
        }
        return undefined;
    };

    const updateCamera = (): void => {
        const { zoomLevel, autoZoom } = props;
        setTimeout(() => {
            if (bounds && map.current) {
                try {
                    if (!autoZoom) {
                        map.current.setCenter({
                            lat: markers[0].getPosition()?.lat() ?? defaultCenterLocation.lat,
                            lng: markers[0].getPosition()?.lng() ?? defaultCenterLocation.lng
                        });
                        map.current.setZoom(zoomLevel);
                    } else {
                        map.current.fitBounds(bounds);
                    }
                } catch (error) {
                    setValidationMessage(`Invalid map bounds ${error.message}`);
                }
            }
        }, 0);
    };

    const getMapStyles = (): google.maps.MapTypeStyle[] => {
        if (props.mapStyles && props.mapStyles.trim()) {
            try {
                return JSON.parse(props.mapStyles);
            } catch (error) {
                setValidationMessage(`invalid Map styles, ${error.message}`);
            }
        }

        return [
            {
                featureType: "poi",
                elementType: "labels",
                stylers: [{ visibility: "off" }]
            }
        ];
    };

    return (
        <div
            className={classNames("widget-maps", props.className)}
            style={{ ...props.divStyles, ...getDimensions(props) }}
        >
            {validationMessage && (
                <Alert bootstrapStyle="danger" className="widget-google-maps-alert">
                    {validationMessage}
                </Alert>
            )}
            <div className="widget-google-maps-wrapper">
                <div className="widget-google-maps" ref={googleMapsRef} />
            </div>
        </div>
    );
};

export default googleApiWrapper("https://maps.googleapis.com/maps/api/js?key=")(GoogleMap);
