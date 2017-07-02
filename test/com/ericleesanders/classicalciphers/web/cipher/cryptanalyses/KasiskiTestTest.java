package com.ericleesanders.classicalciphers.web.cipher.cryptanalyses;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.ericleesanders.classicalciphers.web.log.CipherLogger;

public class KasiskiTestTest {

    /**
     * Text and probabilities from Thomas Barr - www.tbarr.net
     */
    @Test
    public void kasiskiTest1() {

        String cipherText = "HIBKAUQFLFSBQSXSKCFBYOAGPALGTCRTYTLDGBYOAGPALOAKYBFBILYOYQTDISVAIJJNNADXNLWNRQPFBVPWNIWAFBYAANRURTZELYZLFMEWHIBKAUQFLALJGTXRGVNIJPZREQLKWZA";

        Set<Integer> expectedLengths = new HashSet<Integer>();
        expectedLengths.add(2);
        expectedLengths.add(18);
        expectedLengths.add(3);
        expectedLengths.add(6);
        expectedLengths.add(9);

        Set<Integer> lengths = KasiskiTest.kasiskiTest(cipherText, new CipherLogger());

        assertEquals(expectedLengths, lengths);
    }
}
