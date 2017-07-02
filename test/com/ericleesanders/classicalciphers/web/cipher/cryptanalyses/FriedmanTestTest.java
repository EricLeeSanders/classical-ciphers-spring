package com.ericleesanders.classicalciphers.web.cipher.cryptanalyses;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.ericleesanders.classicalciphers.web.cipher.util.CipherUtil;

public class FriedmanTestTest {

    /**
     * Text and probabilities from Barr - Invitation to Cryptology pg. 138
     */
    @Test
    public void friedmanTest1() {

        String cipherText = "IYMECGOBDOJBSNTVAQLNBIEAOYIOHVXZYZYLEEVIPWOBBOEIVZHWUDEAQALLKROCUWSWRYSIUYBMAEIRDEFYYLKODKOGIKPHPRDEJIPWLLWPHRKYMBMAKNGMRELYDPHRNPZHBYJDPMMWBXEYOZJMYXNYJDQWYMEOGPYBCXSXXYHLBELLEPRDEGWXLEPMNOCMRTGQQOUPPEDPSLZOJAEYWNMKRFBLPGIMQAYTSHMRCKTUMVSTVDBOEUEEVRGJGGPIATDRARABLPGIMQDBCFWXDFAWUWPPMRGJGNOETGDMCIIMEXTBEENBNICKYPWNQBLPGIMQOELICMRCLACMV";
        List<Character> cipherList = CipherUtil.convertStringToCharacterList(cipherText);

        double expectedKeyLength = 6.0011714890473264;
        double keyLength = FriedmanTest.friedmanTest(cipherList);

        assertEquals(expectedKeyLength, keyLength, 0.0000001);
    }

}
