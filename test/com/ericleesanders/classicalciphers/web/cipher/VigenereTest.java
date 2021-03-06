package com.ericleesanders.classicalciphers.web.cipher;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ericleesanders.classicalciphers.web.cipher.VigenereCipher;
import com.ericleesanders.classicalciphers.web.log.CipherLogger;

public class VigenereTest {

    @Test
    public void vigenereEncryptionTest1() {

        String key = "LINCOLN";
        String plainText = "FOURSCOREANDSEVENYEARSAGOOURFATHERSBROUGHTFORTHONTHISCONTINENTANEWNATIONCONCEIVEDINLIBERTYANDDEDICATEDTOTHEPROPOSITIONTHATALLMENARECREATEDEQUALNOWWEAREENGAGEDINAGREATCIVILWARTESTINGWHETHERTHATNATIONORANYNATIONSOCONCEIVEDANDSODEDICATEDCANLONGENDUREWEAREMETONAGREATBATTLEFIELDOFTHATWARWEHAVECOMETODEDICATEAPORTIONOFTHATFIELDASAFINALRESTINGPLACEFORTHOSEWHOHEREGAVETHEIRLIVESTHATTHATNATIONMIGHTLIVEITISALTOGETHERFITTINGANDPROPERTHATWESHOULDDOTHISBUTINALARGERSENSEWECANNOTDEDICATEWECANNOTCONSECRATEWECANNOTHALLOWTHISGROUNDTHEBRAVEMENLIVINGANDDEADWHOSTRUGGLEDHEREHAVECONSECRATEDITFARABOVEOURPOORPOWERTOADDORDETRACTTHEWORLDWILLLITTLENOTENORLONGREMEMBERWHATWESAYHEREBUTITCANNEVERFORGETWHATTHEYDIDHEREITISFORUSTHELIVINGRATHERTOBEDEDICATEDHERETOTHEUNFINISHEDWORKWHICHTHEYWHOFOUGHTHEREHAVETHUSFARSONOBLYADVANCEDITISRATHERFORUSTOBEHEREDEDICATEDTOTHEGREATTASKREMAININGBEFOREUSTHATFROMTHESEHONOREDDEADWETAKEINCREASEDDEVOTIONTOTHATCAUSEFORWHICHTHEYGAVETHELASTFULLMEASUREOFDEVOTIONTHATWEHEREHIGHLYRESOLVETHATTHESEDEADSHALLNOTHAVEDIEDINVAINTHATTHISNATIONUNDERGODSHALLHAVEANEWBIRTHOFFREEDOMANDTHATGOVERNMENTOFTHEPEOPLEBYTHEPEOPLEFORTHEPEOPLESHALLNOTPERISHFROMTHEEARTH";
        String expectedCipherText = "QWHTGNBCMNPRDRGMAASLEDITQCFEQIGJSCFMZBWUSGQWEVVZAEPVUQZAEQAGBENYMJPOEVZVPQBNRTDRFWYYTJRTHJNYLQGRTPLBRFHZGSMCTCABDQGKCYGSIGCZWZPVNTSNEPIGGRPDFIYPCHJPIEGSYTLORFWYNRZRCHNVGQYYOCGPAGKBRJSMGJSCGSIGPOEVZVBTOYLYIGKCYFZKBPQPVGMQCBOFZLRFWNNEMQEOYYZVTGBOHCMJGOCRXMGQBLTCMNVPLGETRHWPYOWSVVLGHIEYSSNGMPQAPGZLRFWNNEMNRCCGTWAQTEULBSKSWQLANHWYNWZRUHTARXYCQPSZZGJCDRHPBJSCRRIIGHSRTZYKJPFEPNVHSNEVNVWZAXQTJHWVGMVVWDNWBBISEUPZSKHEVYONPRAEZXRTHSNEERUVZHWLQQHSVDJHVWYNWIEISCFPVFGKPPLVAQHOROQPCHPJPKNPBZGNWAUSNELBRYSNNYVBVVLYWWJVVTFRZBWBOGSMOTOGRXMANWGVYONPRORLLJJCDGCCTIZPQSMEGVLIPKBPGPPCIGGRTGQIECPZIPWHTDZBCXBYSCGZIQFCCQPBECQEGSMJQFWQHQYNZTGETRPCERYWENCYTCMZGAMRCEUCHHRDILJSCRMCGKHNNYVRXSCSZZTGHHULBGJSJQTLUGFPVEQFHCCHDBUGZTITVTTOEUPZGQPPQPLVEOEROPRTSEBEPRWBQVYQFJSOJZZXYVTPSBUGMHUZNBWUSGSMEGVLIPBUWGQNCABPCMYJIQXOYPPLVVWDELBUGFQBCCFVCMRSMEGRPQTKNVSOGZBUGUCRLBGCGVEPUNKBTARJRHCCRFAGJOESCWZVVPFPPBPCCROLRCRHREIXGWYPCMNUSOQPDBVWZAEWGJOEPLCFGTZEHPVEVEUPGTCJPGSMYCGESFTYOSLFFZRQTORGWGKCYGSIGYSSRCMUKUSYJZRUCWIPBUCHEUPARFSLQDPNNZYBEPNXSOVPLVPJLVYBUCHEUTAACHTBYCAFSCTZLFJOWYSIIGOYRHJVTHSBQNEGSOBXIAFHSNEOBXSCAXMAVCQGSMCGCAYPJLVVPCPWCNSQBCBUGDPBATRUVLYWVBVDPETAUHFZZEPRGOCGS";

        String cipherText = VigenereCipher.encrypt(plainText, key, new CipherLogger());

        assertEquals(expectedCipherText, cipherText);

    }

    @Test
    public void shiftDecryptionTest1() {

        String key = "LINCOLN";
        String expectedPlainText = "FOURSCOREANDSEVENYEARSAGOOURFATHERSBROUGHTFORTHONTHISCONTINENTANEWNATIONCONCEIVEDINLIBERTYANDDEDICATEDTOTHEPROPOSITIONTHATALLMENARECREATEDEQUALNOWWEAREENGAGEDINAGREATCIVILWARTESTINGWHETHERTHATNATIONORANYNATIONSOCONCEIVEDANDSODEDICATEDCANLONGENDUREWEAREMETONAGREATBATTLEFIELDOFTHATWARWEHAVECOMETODEDICATEAPORTIONOFTHATFIELDASAFINALRESTINGPLACEFORTHOSEWHOHEREGAVETHEIRLIVESTHATTHATNATIONMIGHTLIVEITISALTOGETHERFITTINGANDPROPERTHATWESHOULDDOTHISBUTINALARGERSENSEWECANNOTDEDICATEWECANNOTCONSECRATEWECANNOTHALLOWTHISGROUNDTHEBRAVEMENLIVINGANDDEADWHOSTRUGGLEDHEREHAVECONSECRATEDITFARABOVEOURPOORPOWERTOADDORDETRACTTHEWORLDWILLLITTLENOTENORLONGREMEMBERWHATWESAYHEREBUTITCANNEVERFORGETWHATTHEYDIDHEREITISFORUSTHELIVINGRATHERTOBEDEDICATEDHERETOTHEUNFINISHEDWORKWHICHTHEYWHOFOUGHTHEREHAVETHUSFARSONOBLYADVANCEDITISRATHERFORUSTOBEHEREDEDICATEDTOTHEGREATTASKREMAININGBEFOREUSTHATFROMTHESEHONOREDDEADWETAKEINCREASEDDEVOTIONTOTHATCAUSEFORWHICHTHEYGAVETHELASTFULLMEASUREOFDEVOTIONTHATWEHEREHIGHLYRESOLVETHATTHESEDEADSHALLNOTHAVEDIEDINVAINTHATTHISNATIONUNDERGODSHALLHAVEANEWBIRTHOFFREEDOMANDTHATGOVERNMENTOFTHEPEOPLEBYTHEPEOPLEFORTHEPEOPLESHALLNOTPERISHFROMTHEEARTH";
        String cipherText = "QWHTGNBCMNPRDRGMAASLEDITQCFEQIGJSCFMZBWUSGQWEVVZAEPVUQZAEQAGBENYMJPOEVZVPQBNRTDRFWYYTJRTHJNYLQGRTPLBRFHZGSMCTCABDQGKCYGSIGCZWZPVNTSNEPIGGRPDFIYPCHJPIEGSYTLORFWYNRZRCHNVGQYYOCGPAGKBRJSMGJSCGSIGPOEVZVBTOYLYIGKCYFZKBPQPVGMQCBOFZLRFWNNEMQEOYYZVTGBOHCMJGOCRXMGQBLTCMNVPLGETRHWPYOWSVVLGHIEYSSNGMPQAPGZLRFWNNEMNRCCGTWAQTEULBSKSWQLANHWYNWZRUHTARXYCQPSZZGJCDRHPBJSCRRIIGHSRTZYKJPFEPNVHSNEVNVWZAXQTJHWVGMVVWDNWBBISEUPZSKHEVYONPRAEZXRTHSNEERUVZHWLQQHSVDJHVWYNWIEISCFPVFGKPPLVAQHOROQPCHPJPKNPBZGNWAUSNELBRYSNNYVBVVLYWWJVVTFRZBWBOGSMOTOGRXMANWGVYONPRORLLJJCDGCCTIZPQSMEGVLIPKBPGPPCIGGRTGQIECPZIPWHTDZBCXBYSCGZIQFCCQPBECQEGSMJQFWQHQYNZTGETRPCERYWENCYTCMZGAMRCEUCHHRDILJSCRMCGKHNNYVRXSCSZZTGHHULBGJSJQTLUGFPVEQFHCCHDBUGZTITVTTOEUPZGQPPQPLVEOEROPRTSEBEPRWBQVYQFJSOJZZXYVTPSBUGMHUZNBWUSGSMEGVLIPBUWGQNCABPCMYJIQXOYPPLVVWDELBUGFQBCCFVCMRSMEGRPQTKNVSOGZBUGUCRLBGCGVEPUNKBTARJRHCCRFAGJOESCWZVVPFPPBPCCROLRCRHREIXGWYPCMNUSOQPDBVWZAEWGJOEPLCFGTZEHPVEVEUPGTCJPGSMYCGESFTYOSLFFZRQTORGWGKCYGSIGYSSRCMUKUSYJZRUCWIPBUCHEUPARFSLQDPNNZYBEPNXSOVPLVPJLVYBUCHEUTAACHTBYCAFSCTZLFJOWYSIIGOYRHJVTHSBQNEGSOBXIAFHSNEOBXSCAXMAVCQGSMCGCAYPJLVVPCPWCNSQBCBUGDPBATRUVLYWVBVDPETAUHFZZEPRGOCGS";

        String plainText = VigenereCipher.decrypt(cipherText, key, new CipherLogger());

        assertEquals(expectedPlainText, plainText);

    }

    @Test
    public void shiftAutoDecryptionTest1() {

        String expectedKey = "LINCOLN";
        String cipherText = "QWHTGNBCMNPRDRGMAASLEDITQCFEQIGJSCFMZBWUSGQWEVVZAEPVUQZAEQAGBENYMJPOEVZVPQBNRTDRFWYYTJRTHJNYLQGRTPLBRFHZGSMCTCABDQGKCYGSIGCZWZPVNTSNEPIGGRPDFIYPCHJPIEGSYTLORFWYNRZRCHNVGQYYOCGPAGKBRJSMGJSCGSIGPOEVZVBTOYLYIGKCYFZKBPQPVGMQCBOFZLRFWNNEMQEOYYZVTGBOHCMJGOCRXMGQBLTCMNVPLGETRHWPYOWSVVLGHIEYSSNGMPQAPGZLRFWNNEMNRCCGTWAQTEULBSKSWQLANHWYNWZRUHTARXYCQPSZZGJCDRHPBJSCRRIIGHSRTZYKJPFEPNVHSNEVNVWZAXQTJHWVGMVVWDNWBBISEUPZSKHEVYONPRAEZXRTHSNEERUVZHWLQQHSVDJHVWYNWIEISCFPVFGKPPLVAQHOROQPCHPJPKNPBZGNWAUSNELBRYSNNYVBVVLYWWJVVTFRZBWBOGSMOTOGRXMANWGVYONPRORLLJJCDGCCTIZPQSMEGVLIPKBPGPPCIGGRTGQIECPZIPWHTDZBCXBYSCGZIQFCCQPBECQEGSMJQFWQHQYNZTGETRPCERYWENCYTCMZGAMRCEUCHHRDILJSCRMCGKHNNYVRXSCSZZTGHHULBGJSJQTLUGFPVEQFHCCHDBUGZTITVTTOEUPZGQPPQPLVEOEROPRTSEBEPRWBQVYQFJSOJZZXYVTPSBUGMHUZNBWUSGSMEGVLIPBUWGQNCABPCMYJIQXOYPPLVVWDELBUGFQBCCFVCMRSMEGRPQTKNVSOGZBUGUCRLBGCGVEPUNKBTARJRHCCRFAGJOESCWZVVPFPPBPCCROLRCRHREIXGWYPCMNUSOQPDBVWZAEWGJOEPLCFGTZEHPVEVEUPGTCJPGSMYCGESFTYOSLFFZRQTORGWGKCYGSIGYSSRCMUKUSYJZRUCWIPBUCHEUPARFSLQDPNNZYBEPNXSOVPLVPJLVYBUCHEUTAACHTBYCAFSCTZLFJOWYSIIGOYRHJVTHSBQNEGSOBXIAFHSNEOBXSCAXMAVCQGSMCGCAYPJLVVPCPWCNSQBCBUGDPBATRUVLYWVBVDPETAUHFZZEPRGOCGS";

        String key = VigenereCipher.autoDecrypt(cipherText, new CipherLogger());

        assertEquals(expectedKey, key);

    }
}
