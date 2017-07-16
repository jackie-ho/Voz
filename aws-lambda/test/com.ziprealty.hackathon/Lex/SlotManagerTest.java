package com.ziprealty.hackathon.Lex;

import org.junit.Assert;
import org.junit.Test;

import static com.ziprealty.hackathon.Lex.SlotManager.slotExists;

/**
 * Created by jamgale on 7/15/17.
 *
 * Tests the slot manager object, getting and putting slots into our bot
 */

public class SlotManagerTest {

    @Test
    public void slotExistsReturnsTrueWhenSlotExists() {

        Assert.assertTrue(slotExists("AMAZON.Person"));

    }

}
