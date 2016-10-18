-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: classical_ciphers
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ex_affine_cipher`
--

DROP TABLE IF EXISTS `ex_affine_cipher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_affine_cipher` (
  `row_id` int(11) NOT NULL AUTO_INCREMENT,
  `ct_id` int(11) NOT NULL,
  `shift_amount_a` int(11) NOT NULL,
  `shift_amount_b` int(11) NOT NULL,
  PRIMARY KEY (`row_id`),
  UNIQUE KEY `row_id_UNIQUE` (`row_id`),
  KEY `fk_ct_id_affine_idx` (`ct_id`),
  CONSTRAINT `fk_ct_id_affine` FOREIGN KEY (`ct_id`) REFERENCES `ex_cipher_text` (`ct_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_affine_cipher`
--

LOCK TABLES `ex_affine_cipher` WRITE;
/*!40000 ALTER TABLE `ex_affine_cipher` DISABLE KEYS */;
INSERT INTO `ex_affine_cipher` VALUES (2,12,11,12),(3,13,5,19),(4,14,21,4),(5,15,19,1),(6,16,15,17),(7,17,7,11);
/*!40000 ALTER TABLE `ex_affine_cipher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ex_cipher_text`
--

DROP TABLE IF EXISTS `ex_cipher_text`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_cipher_text` (
  `ct_id` int(11) NOT NULL AUTO_INCREMENT,
  `pt_id` int(11) NOT NULL,
  `cipher_text` text NOT NULL,
  PRIMARY KEY (`ct_id`),
  UNIQUE KEY `ct_id_UNIQUE` (`ct_id`),
  KEY `fk_pt_id_cipher_text_idx` (`pt_id`),
  CONSTRAINT `fk_pt_id_cipher_text` FOREIGN KEY (`pt_id`) REFERENCES `ex_plain_text` (`pt_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_cipher_text`
--

LOCK TABLES `ex_cipher_text` WRITE;
/*!40000 ALTER TABLE `ex_cipher_text` DISABLE KEYS */;
INSERT INTO `ex_cipher_text` VALUES (1,3,'BBBBBB'),(2,4,'TEST_SUB'),(3,5,'TEST2_SUB'),(4,6,'test_vig'),(5,7,'IKXITKXMAXYHKVXLPXTMMTVDTMFBWGBZAM'),(6,8,'IKXITKXMAXYHKVXLPXTMMTVDTMFBWGBZAM'),(7,9,'KOIQKPIVQUPGCMKPVQVJGDWKNFKPIVQPKIJVKNNUKIPCNYJGPKOKP'),(8,10,'ZNKEJUTZQTUCZNGZOSYVEOTMUTZNKS'),(9,11,'VGZSRSGDVHEHOZRRVNQC'),(10,12,'BXRWPTAHRDUXTASXBVTIIXCVNDJDJIDUWTGTAXCRDAC'),(11,13,'KYVFUFIVSRXNVCCNVRIVTRGKZMVJFWFLIFNEZUVEKZKZVJCZMZEXZEGIZJFEJFWFLIFNETIVRKZFEJ'),(12,14,'VREVMRENLEPKRIECUEMNNMISMNOWTZWALN'),(13,15,'HBXLHGXKLFGNTRHGKLKCNYPHWIHGXKLGHXCKHWWFHXGTWZCNGHBHG'),(14,16,'NVKOPMRNGRMYNVENQWSHOQRAMRNVKW'),(15,17,'DEBYFYEZDXSXABFFDHMG'),(16,18,'PHVSRZABVTOHZAKHPDZQQHEDNTFTFQTOSZMZAHEVTAE'),(17,19,'OINFGFANSLBJNKKJNLANZLMOPCNHFUFVAFJYPGNYOPOPNHKPCPYBPYMAPHFYHFUFVAFJYZANLOPFYH'),(18,20,'YFIYMFIZWIBQFLIRSIMZZMLPMZNDVEDOWZ'),(19,21,'IDNQIJNRQLJUSVIJRQRCUBXIEOIJNRQJINCRIEELINJSEGCUJIDIJ'),(20,22,'CUJTGNKCBKNLCUSCXHYRTXKQNKCUJH'),(21,23,'GCPRKRCUGIZIWPKKGQFN'),(22,24,'OWUFPDXBUYVWDXRWOIDLLWHIKYEYELYVFDZDXWHUYXH'),(23,25,'WBPALANPCTYKPQQKPTNPHTEWDFPRAUAGNAKZDLPZWDWDPRQDFDZYDZENDRAZRAUAGNAKZHNPTWDAZR'),(24,26,'QWHTGNBCMNPRDRGMAASLEDITQCFEQIGJSCFMZBWUSGQWEVVZAEPVUQZAEQAGBENYMJPOEVZVPQBNRTDRFWYYTJRTHJNYLQGRTPLBRFHZGSMCTCABDQGKCYGSIGCZWZPVNTSNEPIGGRPDFIYPCHJPIEGSYTLORFWYNRZRCHNVGQYYOCGPAGKBRJSMGJSCGSIGPOEVZVBTOYLYIGKCYFZKBPQPVGMQCBOFZLRFWNNEMQEOYYZVTGBOHCMJGOCRXMGQBLTCMNVPLGETRHWPYOWSVVLGHIEYSSNGMPQAPGZLRFWNNEMNRCCGTWAQTEULBSKSWQLANHWYNWZRUHTARXYCQPSZZGJCDRHPBJSCRRIIGHSRTZYKJPFEPNVHSNEVNVWZAXQTJHWVGMVVWDNWBBISEUPZSKHEVYONPRAEZXRTHSNEERUVZHWLQQHSVDJHVWYNWIEISCFPVFGKPPLVAQHOROQPCHPJPKNPBZGNWAUSNELBRYSNNYVBVVLYWWJVVTFRZBWBOGSMOTOGRXMANWGVYONPRORLLJJCDGCCTIZPQSMEGVLIPKBPGPPCIGGRTGQIECPZIPWHTDZBCXBYSCGZIQFCCQPBECQEGSMJQFWQHQYNZTGETRPCERYWENCYTCMZGAMRCEUCHHRDILJSCRMCGKHNNYVRXSCSZZTGHHULBGJSJQTLUGFPVEQFHCCHDBUGZTITVTTOEUPZGQPPQPLVEOEROPRTSEBEPRWBQVYQFJSOJZZXYVTPSBUGMHUZNBWUSGSMEGVLIPBUWGQNCABPCMYJIQXOYPPLVVWDELBUGFQBCCFVCMRSMEGRPQTKNVSOGZBUGUCRLBGCGVEPUNKBTARJRHCCRFAGJOESCWZVVPFPPBPCCROLRCRHREIXGWYPCMNUSOQPDBVWZAEWGJOEPLCFGTZEHPVEVEUPGTCJPGSMYCGESFTYOSLFFZRQTORGWGKCYGSIGYSSRCMUKUSYJZRUCWIPBUCHEUPARFSLQDPNNZYBEPNXSOVPLVPJLVYBUCHEUTAACHTBYCAFSCTZLFJOWYSIIGOYRHJVTHSBQNEGSOBXIAFHSNEOBXSCAXMAVCQGSMCGCAYPJLVVPCPWCNSQBCBUGDPBATRUVLYWVBVDPETAUHFZZEPRGOCGS'),(25,27,'MIEUWPRKUBGCXMLCXBRKVBPZBWEYHGOAKPWTBEETMJTOXTLOOJNMBOPXBTOTLPFUNSOCGDRKTUIUGT'),(26,28,'BPVSARJJQIMWRMDGPPWMEVSRVVWZBWYGSIZDWHUSVIWOTBASUBJNESSCRXSBNNRRIKCGZAGBONLIVTZESGGIVVESLRASDCSFECRTUJQHUFTSMZPEGLVRDFQPKCPQKOPPIVUZIFZYOAJQETSDEQFJBMMIDSCRTDZRWVPSYUZVVIFUICAXSXWNSEODINDIYMQUNWVQEDLFWHHVPEWBBTRSGBRPWXHOXIUWBWBDISGWZALZRSFYTYUKPSHCSZWOXDIMDGRUYIYGDLTVYVMCXHODETQKBNRRIOKVZDCIFUHRCPIILOADIIDSXYMDRHQDCEXSFNLVREVELKCUQTFBLVAHSHKTWFBVKFUDIYMUCZQRRYDWVGCWYMVHSKGRIFMJBPMDYCKSFCJXYCTRTTWEDNOPAAXIVLBOZFJAHSHKTWFBVKSFZGZAGBOVKMVOIIIUYREYMMRTIMLCYPJENQTCMKVRTNMTRPEWLVRSTSMZPEGSUROKMKXDNWFZLBJKROITPWBGIVWAWTROWBGXYSMEGUMJSQTRVADWZAWBQTKSDKNZKSARIVVECTVSABTKLWTSRVBZSWVJXIMTZVGKXOFATRTJGKHRNTENXDKXJCIJUISYXWGGIEFIIANXEOLVVTCITDTIGGIYMBROGXUQWRNWVRGSCXASFNTUIADW');
/*!40000 ALTER TABLE `ex_cipher_text` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ex_plain_text`
--

DROP TABLE IF EXISTS `ex_plain_text`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_plain_text` (
  `pt_id` int(11) NOT NULL AUTO_INCREMENT,
  `plain_text` text NOT NULL,
  PRIMARY KEY (`pt_id`),
  UNIQUE KEY `pt_id_UNIQUE` (`pt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_plain_text`
--

LOCK TABLES `ex_plain_text` WRITE;
/*!40000 ALTER TABLE `ex_plain_text` DISABLE KEYS */;
INSERT INTO `ex_plain_text` VALUES (1,'This is a test of the classical ciphers program written by Eric Sanders'),(3,'AAAAAA'),(4,'SUB_TEST'),(5,'SUB2_TEST'),(6,'vig_test'),(7,'Prepare the forces. We attack at midnight.'),(8,'Prepare the forces. We attack at midnight.'),(9,'I\'m going to sneak into the building tonight. I\'ll signal when I\'m in.'),(10,'They don\'t know that I\'m spying on them.'),(11,'What\'s the wifi password?'),(12,'Michael Scofield: I\'m getting you out of here Lincoln.'),(13,'Theodore Bagwell: We are captives of our own identities. Living in prisons of our own creations.'),(14,'Prepare the forces. We attack at midnight.'),(15,'I\'m going to sneak into the building tonight. I\'ll signal when I\'m in.'),(16,'They don\'t know that I\'m spying on them.'),(17,'What\'s the wifi password?'),(18,'Michael Scofield: I\'m getting you out of here Lincoln.'),(19,'Theodore Bagwell: We are captives of our own identities. Living in prisons of our own creations.'),(20,'Prepare the forces. We attack at midnight.'),(21,'I\'m going to sneak into the building tonight. I\'ll signal when I\'m in.'),(22,'They don\'t know that I\'m spying on them.'),(23,'What\'s the wifi password?'),(24,'Michael Scofield: I\'m getting you out of here Lincoln.'),(25,'Theodore Bagwell: We are captives of our own identities. Living in prisons of our own creations.'),(26,'Four score and seven years ago our fathers brought forth on this continent, a new nation, conceived in Liberty, and dedicated to the proposition that all men are created equal.\n\nNow we are engaged in a great civil war, testing whether that nation, or any nation so conceived and so dedicated, can long endure. We are met on a great battle-field of that war. We have come to dedicate a portion of that field, as a final resting place for those who here gave their lives that that nation might live. It is altogether fitting and proper that we should do this.\n\nBut, in a larger sense, we can not dedicate -- we can not consecrate -- we can not hallow -- this ground. The brave men, living and dead, who struggled here, have consecrated it, far above our poor power to add or detract. The world will little note, nor long remember what we say here, but it can never forget what they did here. It is for us the living, rather, to be dedicated here to the unfinished work which they who fought here have thus far so nobly advanced. It is rather for us to be here dedicated to the great task remaining before us -- that from these honored dead we take increased devotion to that cause for which they gave the last full measure of devotion -- that we here highly resolve that these dead shall not have died in vain -- that this nation, under God, shall have a new birth of freedom -- and that government of the people, by the people, for the people, shall not perish from the earth.'),(27,'Theodore Bagwell: We are captives of our own identities. Living in prisons of our own creations.'),(28,'My name is Michael Scofield, and I\'m a fugitive. Three weeks ago, I was in a Panamanian prison. While I was there, I was approached by the Company. The Company is a corrupt organization involved in all levels of industry and government. They gave me two options: break one of their men, James Whistler, out of that prison or else they would kill the only woman I ever loved, Dr. Sara Tancredi. I held up my end of the deal, and I broke Whistler out. But the Company ... They killed Sara anyway. I don\'t know why the Company wanted James Whistler out of prison, but I\'ve tracked him here to Los Angeles. He\'s with another Company agent I know only as Gretchen. The same agent who murdered Sara. This ends today. I came here seeking justice. The justice I now know the system cannot provide. So, if you\'re reading this letter, you\'ll know I died avenging Sara\'s death.');
/*!40000 ALTER TABLE `ex_plain_text` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ex_shift_cipher`
--

DROP TABLE IF EXISTS `ex_shift_cipher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_shift_cipher` (
  `row_id` int(11) NOT NULL AUTO_INCREMENT,
  `ct_id` int(11) NOT NULL,
  `shift_amount` int(11) NOT NULL,
  PRIMARY KEY (`row_id`),
  UNIQUE KEY `row_id_UNIQUE` (`row_id`),
  KEY `fk_ct_id_shift_idx` (`ct_id`),
  CONSTRAINT `fk_ct_id_shift` FOREIGN KEY (`ct_id`) REFERENCES `ex_cipher_text` (`ct_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_shift_cipher`
--

LOCK TABLES `ex_shift_cipher` WRITE;
/*!40000 ALTER TABLE `ex_shift_cipher` DISABLE KEYS */;
INSERT INTO `ex_shift_cipher` VALUES (3,6,19),(4,7,2),(5,8,6),(6,9,25),(7,10,15),(8,11,17);
/*!40000 ALTER TABLE `ex_shift_cipher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ex_substitution_cipher`
--

DROP TABLE IF EXISTS `ex_substitution_cipher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_substitution_cipher` (
  `row_id` int(11) NOT NULL AUTO_INCREMENT,
  `ct_id` int(11) NOT NULL,
  `cipher_key` tinytext NOT NULL,
  PRIMARY KEY (`row_id`),
  UNIQUE KEY `row_id_UNIQUE` (`row_id`),
  KEY `fk_ct_id_substitution_idx` (`ct_id`),
  CONSTRAINT `fk_ct_id_substitution` FOREIGN KEY (`ct_id`) REFERENCES `ex_cipher_text` (`ct_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_substitution_cipher`
--

LOCK TABLES `ex_substitution_cipher` WRITE;
/*!40000 ALTER TABLE `ex_substitution_cipher` DISABLE KEYS */;
INSERT INTO `ex_substitution_cipher` VALUES (2,18,'MIDNIGHT'),(3,19,'SNEAK'),(4,20,'SPY'),(5,21,'PLEASE'),(6,22,'PRISON BREAK'),(7,23,'TBAG');
/*!40000 ALTER TABLE `ex_substitution_cipher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ex_vigenere_cipher`
--

DROP TABLE IF EXISTS `ex_vigenere_cipher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_vigenere_cipher` (
  `row_id` int(11) NOT NULL AUTO_INCREMENT,
  `ct_id` int(11) NOT NULL,
  `cipher_key` tinytext NOT NULL,
  PRIMARY KEY (`row_id`),
  UNIQUE KEY `row_id_UNIQUE` (`row_id`),
  KEY `fk_ct_id_vigenere_idx` (`ct_id`),
  CONSTRAINT `fk_ct_id_vigenere` FOREIGN KEY (`ct_id`) REFERENCES `ex_cipher_text` (`ct_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_vigenere_cipher`
--

LOCK TABLES `ex_vigenere_cipher` WRITE;
/*!40000 ALTER TABLE `ex_vigenere_cipher` DISABLE KEYS */;
INSERT INTO `ex_vigenere_cipher` VALUES (2,24,'LINCOLN'),(3,25,'TBAG'),(4,26,'PRISON BREAK');
/*!40000 ALTER TABLE `ex_vigenere_cipher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'classical_ciphers'
--
/*!50003 DROP PROCEDURE IF EXISTS `usp_I_ex_affine_cipher` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_I_ex_affine_cipher`(
	p_plain_text TEXT,
    p_cipher_text TEXT,
    p_shift_amount_a INT,
	p_shift_amount_b INT
)
BEGIN
	INSERT INTO ex_plain_text(plain_text) VALUES (p_plain_text);
    SET @pt_id = LAST_INSERT_ID();
    INSERT INTO ex_cipher_text(pt_id, cipher_text) VALUES(@pt_id, p_cipher_text);
    SET @ct_id = LAST_iNSERT_ID();
    INSERT INTO ex_affine_cipher(ct_id, shift_amount_a, shift_amount_b) VALUES(@ct_id, p_shift_amount_a, p_shift_amount_b);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_I_ex_shift_cipher` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_I_ex_shift_cipher`(
	p_plain_text TEXT,
    p_cipher_text TEXT,
    p_shift_amount INT
)
BEGIN
	INSERT INTO ex_plain_text(plain_text) VALUES (p_plain_text);
    SET @pt_id = LAST_INSERT_ID();
    INSERT INTO ex_cipher_text(pt_id, cipher_text) VALUES(@pt_id, p_cipher_text);
    SET @ct_id = LAST_iNSERT_ID();
    INSERT INTO ex_shift_cipher(ct_id, shift_amount) VALUES(@ct_id, p_shift_amount);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_I_ex_substitution_cipher` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_I_ex_substitution_cipher`(
	p_plain_text TEXT,
    p_cipher_text TEXT,
	p_cipher_key TINYTEXT
)
BEGIN
	INSERT INTO ex_plain_text(plain_text) VALUES (p_plain_text);
    SET @pt_id = LAST_INSERT_ID();
    INSERT INTO ex_cipher_text(pt_id, cipher_text) VALUES(@pt_id, p_cipher_text);
    SET @ct_id = LAST_iNSERT_ID();
    INSERT INTO ex_substitution_cipher(ct_id, cipher_key) VALUES(@ct_id, p_cipher_key);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_I_ex_vigenere_cipher` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_I_ex_vigenere_cipher`(
	p_plain_text TEXT,
    p_cipher_text TEXT,
	p_cipher_key TINYTEXT
)
BEGIN
	INSERT INTO ex_plain_text(plain_text) VALUES (p_plain_text);
    SET @pt_id = LAST_INSERT_ID();
    INSERT INTO ex_cipher_text(pt_id, cipher_text) VALUES(@pt_id, p_cipher_text);
    SET @ct_id = LAST_iNSERT_ID();
    INSERT INTO ex_vigenere_cipher(ct_id, cipher_key) VALUES(@ct_id, p_cipher_key);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_S_rnd_ex_affine_cipher` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_S_rnd_ex_affine_cipher`(
OUT plain_text TEXT,
OUT cipher_text TEXT,
OUT shift_amount_a INT,
OUT shift_amount_b INT
)
BEGIN
	SELECT pt.plain_text, ct.cipher_text, affine.shift_amount_a, affine.shift_amount_b 
    INTO plain_text, cipher_text, shift_amount_a, shift_amount_b
    FROM ex_affine_cipher affine
	INNER JOIN ex_cipher_text ct ON ct.ct_id = affine.ct_id
	INNER JOIN ex_plain_text pt ON pt.pt_id = ct.pt_id
    ORDER BY RAND()
    LIMIT 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_S_rnd_ex_shift_cipher` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_S_rnd_ex_shift_cipher`(
OUT plain_text TEXT,
OUT cipher_text TEXT,
OUT shift_amount INT
)
BEGIN
	SELECT pt.plain_text, ct.cipher_text, shift.shift_amount
    INTO plain_text, cipher_text, shift_amount
    FROM ex_shift_cipher shift
	INNER JOIN ex_cipher_text ct ON ct.ct_id = shift.ct_id
	INNER JOIN ex_plain_text pt ON pt.pt_id = ct.pt_id
	ORDER BY RAND()
    LIMIT 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_S_rnd_ex_substitution_cipher` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_S_rnd_ex_substitution_cipher`(
OUT plain_text TEXT,
OUT cipher_text TEXT,
OUT cipher_key TINYTEXT
)
BEGIN
	SELECT pt.plain_text, ct.cipher_text, substitution.cipher_key
    INTO plain_text, cipher_text, cipher_key
    FROM ex_substitution_cipher substitution
	INNER JOIN ex_cipher_text ct ON ct.ct_id = substitution.ct_id
	INNER JOIN ex_plain_text pt ON pt.pt_id = ct.pt_id
	ORDER BY RAND()
    LIMIT 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_S_rnd_ex_vigenere_cipher` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_S_rnd_ex_vigenere_cipher`(
OUT plain_text TEXT,
OUT cipher_text TEXT,
OUT cipher_key TINYTEXT
)
BEGIN
	SELECT pt.plain_text, ct.cipher_text, vigenere.cipher_key
    INTO plain_text, cipher_text, cipher_key
    FROM ex_vigenere_cipher vigenere
	INNER JOIN ex_cipher_text ct ON ct.ct_id = vigenere.ct_id
	INNER JOIN ex_plain_text pt ON pt.pt_id = ct.pt_id
	ORDER BY RAND()
    LIMIT 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-18 16:17:40
