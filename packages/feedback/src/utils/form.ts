import { stringify } from "querystringify";
import { Dimensions, Platform } from "react-native";

const SPRINTR_FEEDBACK_URL = "https://sprintr.home.mendix.com/submitissue/";

export const sendToSprintr = (data: any, cb: (success: boolean) => void) => {
    const shortname = data.feedbackMsg ? data.feedbackMsg.substring(0, 200) : "";
    const description = data.feedbackMsg ? data.feedbackMsg.substring(200) : "";
    const dataToSend = {
        apiversion: "1.0",
        application: data.appId,
        username: "Native Feedback",
        emailaddress: "native@mendix.com",
        userroles: "",
        shortname,
        description,
        img: data.allowScreenshot ? data.screenshot.replace(/(data:image\/png;base64,)/, "") : "",
        browser: "React Native for " + Platform.OS,
        screensize: Dimensions.get("window").width + "x" + Dimensions.get("window").height,
        issuetype: "issue",
        documentType: "Page",
        documentName: "fakepath"
    };

    postToSprintr(dataToSend)
        .then(text => {
            if (cb && typeof cb === "function") {
                cb(true);
            }
            return text;
        })
        .catch(_e => {
            if (cb && typeof cb === "function") {
                cb(false);
            }
        });
};

const postToSprintr = (data: any) =>
    fetch(SPRINTR_FEEDBACK_URL, {
        method: "POST",
        body: stringify(data),
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        mode: "no-cors",
        referrer: "no-referrer"
    }).then(() => {
        return true;
    });