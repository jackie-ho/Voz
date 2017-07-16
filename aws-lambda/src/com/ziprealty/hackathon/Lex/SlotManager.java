package com.ziprealty.hackathon.Lex;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lexmodelbuilding.AmazonLexModelBuilding;
import com.amazonaws.services.lexmodelbuilding.AmazonLexModelBuildingClientBuilder;
import com.amazonaws.services.lexmodelbuilding.model.GetSlotTypeRequest;
import com.amazonaws.services.lexmodelbuilding.model.GetSlotTypeResult;
import com.amazonaws.services.lexruntime.AmazonLexRuntime;
import com.amazonaws.services.lexruntime.AmazonLexRuntimeClientBuilder;
import com.amazonaws.services.lexruntime.model.PostTextRequest;
import com.amazonaws.util.StringUtils;

/**
 * Created by jamgale on 7/15/17.
 */
public class SlotManager {


    /**
     * Check whether a slot of name:
     * @param slotName
     *
     * exists
     */
    public static boolean slotExists(String slotName) {
        AmazonLexModelBuilding modelBuilding = AmazonLexModelBuildingClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
        GetSlotTypeRequest slotTypeRequest = new GetSlotTypeRequest();

        slotTypeRequest.setName(slotName);
        slotTypeRequest.setVersion("$LATEST");
        GetSlotTypeResult slotResult = modelBuilding.getSlotType(slotTypeRequest);
        return !StringUtils.isNullOrEmpty(slotResult.getName());
    }

    public static void putSlot() {
    }
}
