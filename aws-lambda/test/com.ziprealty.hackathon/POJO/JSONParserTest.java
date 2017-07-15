package com.ziprealty.hackathon.POJO;

import com.ziprealty.hackathon.Jackson.JSONParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by jamgale on 7/15/17.
 */

public class JSONParserTest {


    @Before
    public void Setup() {

    }

    @Test
    public void JSONParserParsesSQL_IntoPersonnelObject() {

        String json = "[{\"LEADS_ELECTION_DATE\":\"\",\"RECRUIT_ID\":\"\",\"LEAD_TRAINING_DATE\":\"\",\"FIRST_DESKTOP_LOGIN\":\"2015-08-03 10:46:15.0\",\"CENTURY_CLUB_DATE\":\"\",\"IS_ACTIVE\":\"1\",\"MILEAGE_POSTAL_CODE\":\"\",\"COMPANY_REASSIGNED_LEADS_ON\":\"\",\"OKTA_ID\":\"\",\"STAR_AWARD\":\"0\",\"LOGIN\":\"ben.burnside@era.com\",\"SECONDARY_EMAIL\":\"guangsha.mou@zaplabs.com\",\"TEAM_LEADER_ID\":\"\",\"PERSONNEL_TITLE_ID\":\"\",\"EO_CHARGE\":\"\",\"INSIDE_SALES_OFFSET\":\"0\",\"ACTIVE_DATE\":\"2015-05-13 10:15:49.0\",\"TIME_LOGGED_IN\":\"2017-07-15 12:34:49.0\",\"LOCAL_FAX_ALTERNATE\":\"\",\"PAGER\":\"\",\"HAS_SIGNED_AGREEMENT\":\"0\",\"TEAM_LEADER_TYPE\":\"\",\"IS_SINGLE_SIGN_ON_USER\":\"1\",\"HOME_TERRITORY_ID\":\"3716\",\"PERSONNEL_ID\":\"185667\",\"NUMBER_OF_REVIEWS_CLOSED\":\"0\",\"IS_TEAM_LEADER\":\"0\",\"LEGAL_LAST_NAME\":\"Burnside\",\"IS_EXEMPT\":\"0\",\"LEADS_ELECTION\":\"\",\"ALTERNATE_EMAIL\":\"\",\"FORCE_BENEFITS_SUBMISSION\":\"1\",\"HR_ONBOARDING_COMPLETE\":\"1\",\"STREET_ADDRESS\":\" 7101 Montecito\",\"IS_POWER_AGENT\":\"0\",\"IS_MANAGER\":\"0\",\"MTD_LEADS\":\"0\",\"LEADROUTER_EMAIL\":\"009880.lead.161213@leads.leadrouter.com\",\"IS_AUTO_FOLLOWUP\":\"0\",\"RECRUITING_REGION\":\"\",\"MILEAGE_LATITUDE\":\"\",\"AGREEMENT_PERSONNEL_ID\":\"\",\"SATISFACTION_RATING\":\"\",\"REASSIGNED_LEADS_ON\":\"\",\"PERSONNEL_UNIQUE_ID\":\"\",\"YOUTUBE_VIDEO_ID\":\"6WY3j_ULyPQ\",\"ACCOUNT_BALANCE\":\"\",\"LAST_NAME\":\"Burnside\",\"PROFILE_AREA\":\"\",\"COMPANY_NOTES\":\"\",\"TRAINING_DATE\":\"2015-05-18 00:00:00.0\",\"HIRE_DATE\":\"\",\"POSTAL_CODE\":\"76210\",\"IS_CONTRACTOR\":\"1\",\"LOCAL_AREA\":\"\",\"NUMBER_OF_REVIEWS_NEW\":\"1\",\"WEBMAIL_SERVER\":\"\",\"MTD_LEADS_CAP\":\"\",\"ALT_SECONDARY_EMAIL\":\"\",\"IS_PBZ\":\"0\",\"LOCAL_FAX\":\"\",\"EO_CHARGE_DATE\":\"\",\"HAS_NEW_FAXES\":\"1\",\"COMPANY_ID\":\"64\",\"MGMT_CONTACT_PAGE_ENABLED\":\"1\",\"FAX_DELIVERY_TO_EMAIL\":\"0\",\"WORKDAY_ID\":\"\",\"SUSPENSION_DATE\":\"\",\"PRIMARY_EMAIL\":\"abdismat@cbforms.com\",\"USING_DAY_OFF_DESK\":\"0\",\"PTO_UPDATE_DATE\":\"\",\"NEW_EMPLOYEE_STIPEND\":\"0\",\"DRAW\":\"\",\"METRO_MANUALLY_UPDATED\":\"0\",\"SATISFACTION_RATING_NEW\":\"5\",\"LTM_GCI\":\"\",\"TRAINING_DISTRICT_ID\":\"\",\"MILEAGE_LONGITUDE\":\"\",\"IS_PAYROLL\":\"0\",\"IS_ABOVE_BPR\":\"1\",\"IS_LISTING_EXPERT\":\"0\",\"MOBILE_PHONE\":\"\",\"BOWLIN_CODE\":\"z62x\",\"CITY\":\"Denton\",\"IS_CERTIFIED_SHORT_SALES\":\"\",\"PERSONAL_WEBSITE\":\"\",\"IS_LEAD_ALLOCATION\":\"0\",\"CLIENT_SHOW_REBATE_DEFAULT\":\"\",\"IS_FAST_PAY\":\"1\",\"REFERRAL_PERSONNEL_ID\":\"\",\"PERSONAL_EMAIL\":\"\",\"STATE_NAME\":\"Texas\",\"REALOGY_OFFICE_STAFF_GUID\":\"801e9bf7-cc5d-4d39-902c-d2650d6a65e7\",\"RFG_STAFF_ID\":\"10008\",\"WIRELESS_PIN\":\"\",\"PHONE_STIPEND\":\"\",\"ASSIGNED_SOI_PHONE\":\"\",\"DAILY_LEADS\":\"0\",\"PERSONNEL_GUID\":\"a75d5a1f-acd0-421f-a92d-ab140e3583ce\",\"COUNTRY\":\"US\",\"SATISFACTION_RATING_RECENT\":\"\",\"SHOW_ON_WEBSITE\":\"1\",\"DAILY_LEADS_CAP\":\"3\",\"REALOGY_PERSON_ID\":\"161213\",\"SUSPENSION_REASON\":\"\",\"LAST_DASHBOARD_VIEW_DATE\":\"2015-05-13 10:15:49.0\",\"MILEAGE_STREET_ADDRESS\":\"\",\"IS_CENTURY_CLUB\":\"0\",\"IS_DRAW\":\"\",\"METRO\":\"dallas\",\"OFFICE365_EMAIL\":\"\",\"LEGAL_FIRST_NAME\":\"Benjamin\",\"CHANGE_DATE\":\"2017-07-07 11:16:13.0\",\"WIRELESS_TIME_LOGGED_IN\":\"\",\"MANAGER_ID\":\"0\",\"COMPANY_LEADS_ON\":\"\",\"TERMINATION_DATE\":\"\",\"CREATE_DATE\":\"2015-05-13 10:15:49.0\",\"DEFAULT_LEAD_TYPE\":\"\",\"FORWARDING_EMAIL\":\"\",\"LTM_TRANSACTIONS\":\"\",\"MLS_STIPEND\":\"0\",\"ADP_NUMBER\":\"\",\"ACCOUNT_BALANCE_DATE\":\"\",\"LATITUDE\":\"\",\"WEBMAIL_CLIENT\":\"0\",\"LEAD_ALLOCATION_TIER\":\"\",\"CENTURY_CLUB_TIER\":\"0\",\"LONGITUDE\":\"\",\"MINIMUM_PAY\":\"0\",\"STATE\":\"TX\",\"CAR_STIPEND\":\"\",\"SECONDARY_PHONE\":\"940.368.0963\",\"ASSIGNED_PHONE\":\"\",\"MINIMUM_COMMISSION_PCT\":\"\",\"DASHBOARD_ACTIVITY\":\"\",\"FIRST_NAME\":\"Ben\",\"NOTES\":\"\",\"PROFILE\":\"TestBen is an entrepreneur at heart.  He began his first business at the age of 15 and has started, bought, and sold several other companies since that time.  During college Ben discovered his love for real estate.  He graduated with a BBA in Business Real Estate from the University of North Texas, but not before buying his first rental property.  After college Ben got his real estate license and quickly became the top salesman at ERA Cornerstone and has been recognized nationally as a top producer. Ben attributes his success to building lasting relationships with his clients and delivering service that exceeds expectations. In 2010, Ben obtained his brokers license. Shortly after, Ben and his wife Kristen had the good fortune to partner with David & Alberta Caswell and became co-owners of ERA Cornerstone. As the managing broker, Ben leads a team of 30 top notch realtors. Ben will tell you that one of the team¿s goals is to be the most productive office per agent in DFW.  Growing at an extraordinary pace for the last several years, ERA Cornerstone is well on its way to accomplishing that goal. When not working, Ben can be found spending time with Kristen, his wife of 11 years, and their four children. ¿We do pretty much everything together as a family,¿ says Ben. ¿We are active in our church and community, but we also love to travel, especially to beach destinations.¿ The family also loves outdoor activities such as basketball, biking, fishing, and skiing.\",\"PERSONAL_PHONE\":\"\",\"SIGN_AGREEMENT_BY_DATE\":\"\",\"PTO_REMAINING_HOURS\":\"\",\"EXP_REIMBURSEMENT_GUARANTEED\":\"1\",\"FIRST_MOBILE_LOGIN\":\"2016-03-30 11:34:28.0\",\"IS_ELIGIBLE_TL_PAYMENT\":\"0\",\"IS_LISTING_PROFESSIONAL\":\"0\",\"TEAM_LEADER_ALLOWANCE\":\"0\",\"SHOW_AGENT_PROFILE_VIDEO\":\"1\",\"PRIMARY_DISTRICT_ID\":\"2031\",\"IS_TERMINATED\":\"0\",\"MILEAGE_STATE\":\"\",\"MILEAGE_CITY\":\"\",\"BUSINESS_ENTITY\":\"\",\"PRIMARY_PHONE\":\"940.368.0963\",\"SIGNED_AGREEMENT_DATE\":\"\",\"RECRUITER_ID\":\"\",\"EXTENTION\":\"\",\"RESET_PASSWORD\":\"0\",\"HAS_STOCK_OPTIONS\":\"\",\"OUT_OF_OFFICE\":\"0\",\"IS_LUXURY_DESIGNATION\":\"0\",\"SATISFACTION_RATING_CLOSED\":\"\",\"NUMBER_OF_REVIEWS\":\"\",\"SUSPENSION_PERSONNEL_ID\":\"\",\"IS_SUSPENDED\":\"0\",\"FAX\":\"\",\"ZAP_EMAIL_ADDRESS\":\"\",\"ABOVE_BPR_DATE\":\"\",\"MASTER_LEAD_SETTING\":\"\"}]";


        try {
            List<Personnel> personnelList = JSONParser.parseJSONToPersonnel(json);
            Assert.assertTrue(personnelList.size() == 1);
            Assert.assertEquals(personnelList.get(0).getFirstName(), "Ben");
            Assert.assertEquals(personnelList.get(0).getLastName(), "Burnside");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }
}
