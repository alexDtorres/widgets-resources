import { createElement, ReactElement } from "react";
import GoogleMap, { GoogleMapsProps } from "./GoogleMap";
import { LeafletMap, LeafletProps } from "./LeafletMap";

interface SwitcherProps extends GoogleMapsProps, LeafletProps {}

export const MapSwitcher = (props: SwitcherProps): ReactElement => {
    if (props.mapProvider === "googleMaps") {
        return <GoogleMap {...props} />;
    }
    return <LeafletMap {...props} />;
};
