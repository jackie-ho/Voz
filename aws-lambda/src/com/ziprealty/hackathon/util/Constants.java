package com.ziprealty.hackathon.util;

/**
 * Created by jamgale on 7/14/17.
 */
public final class Constants {

    // RESPONSE PROPERTIES
    public static final String PLAIN_TEXT = "PlainText";
    public static final String FULFILLED = "Fulfilled";
    public static final String CLOSE = "Close";
    public static final String DELEGATE = "Delegate";
    public static final String CONFIRM_INTENT = "ConfirmIntent";
    public static final String ELICIT_INTENT = "ElicitIntent";
    public static final String ELICIT_SLOT = "ElicitSlot";
    public static final String DIALOG_CODE_HOOK = "DialogCodeHook";
    public static final String FULFILLMENT_CODE_HOOK = "FulfillmentCodeHook";

    // INPUT PROPERTIES
    public static final String INVOCATION_SOURCE = "invocationSource";
    public static final String SESSION_ATTRIBUTES = "sessionAttributes";
    public static final String INPUT_TRANSCRIPT = "inputTranscript";
    public static final String CURRENT_INTENT = "currentIntent";
    public static final String CONFIRMATION_STATUS = "confirmationStatus";

    public static final String TODAY = "Today";
    public static final String WEEK = "Week";

    // INTENT NAMES
    public static final String DISPLAY_CONTACT_INTENT = "DisplayContact";
    public static final String SHOW_TODAYS_SCHEDULE = "ShowTodaySchedule";
    public static final String SHOW_WEEK_SCHEDULE = "ShowWeekSchedule";
    public static final String NEXT_EVENT = "NextEvent";
    public static final String CALL_CONTACT = "CallContact";
    public static final String DIRECTIONS = "Directions";
    public static final String HEY_ZAP = "HeyZap";
    public static final String SHOW_CONTACTS = "ShowContacts";

    // SLOT NAMES
    public static final String FULL_NAME = "FullName";

    // SESSION ATTRIBUTES
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";

    public static final    int MAX_STRING_LENGTH = 3000;
}
