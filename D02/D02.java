import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class D02 {

	public static void main(String[] args) {
		calculateChecksum();
		findMostSimilarStrings();
	}
	
	private static void findMostSimilarStrings() {		
		Map<String, Integer> foundSimilarities = new HashMap<String, Integer>();
		
		for (Iterator<String> words = getInput().iterator(); words.hasNext();) {
			final String currentString = words.next();
			
			for (Iterator<String> wordsToCompare = getInput().iterator(); wordsToCompare.hasNext();) {
				final String wordToCompare = wordsToCompare.next();
				String strippedString = "";
				
				//Don't want to compare the same strings...
				if (currentString != wordToCompare) {
					for (int i = 0; i < currentString.length() && i < wordToCompare.length(); i++) {
						if (currentString.charAt(i) == wordToCompare.charAt(i))
							strippedString = strippedString + currentString.charAt(i);
					}
					foundSimilarities.put(strippedString, strippedString.length());
				}
			}
		}
		String greatest = "";
		for (Iterator<Entry<String, Integer>> similarWords = foundSimilarities.entrySet().iterator(); similarWords.hasNext();) {
			Entry<String, Integer> entry = similarWords.next();
			if (entry.getValue() > greatest.length())
				greatest = entry.getKey();
		}
		System.out.println("A2:" + greatest);
	}

	private static void calculateChecksum() {
		int two = 0;
		int three = 0;
		for (Iterator<String> words = getInput().iterator(); words.hasNext();) {
			boolean reportedTwo = false;
			boolean reportedThree = false;
			final String word = words.next();
			Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
			for (int i = 0; i < word.length(); i++) {
				final Character currentCharacter = word.charAt(i);
				final Integer currentCharacterCount = charCountMap.get(currentCharacter);
				if (currentCharacterCount == null)
					charCountMap.put(currentCharacter, 1);
				else
					charCountMap.put(currentCharacter, currentCharacterCount + 1);
			}
			for (Iterator<Entry<Character, Integer>> iterator = charCountMap.entrySet().iterator(); iterator.hasNext();) {
				final Entry<Character, Integer> entry = iterator.next();
				if (!reportedTwo && entry.getValue() == 2) {
					two++;
					reportedTwo = true;
				}
				if (!reportedThree && entry.getValue() == 3) {
					three++;
					reportedThree = true;
				}
			}
		}
		final int A1 = two * three;
		System.out.println("A1:" + A1);
	}

	private static List<String> getInput() {
		return Arrays.asList(
				"wkzhyfdpluzeqvajtbbosngkxc",
				"wrzhyfdplumeqvajtbioskfksc",
				"wrzhyfdolumyqvajtbiosngkxs",
				"urzhyfdplbmeqvrjtbiosngkxc",
				"wrzhyfrulumeqvajtbiosngkxf",
				"wrzhnfdprumvqvajtbiosngkxc",
				"wrzhyfpplumeivajtbiosrgkxc",
				"wrzhybdplumeqvaftbiosxgkxc",
				"wrzgyfdplumeqvaltbiosngcxc",
				"wrzhbfdzlumeqvajtbipsngkxc",
				"wrzhyfdplumwqeajtbiosngxxc",
				"wrzhyddplumeqvajtbimsngkxo",
				"wrzhyfdplumsqdajtfiosngkxc",
				"wrzvyfdplumeqjajtbkosngkxc",
				"wrzhyfddlumeqvujtbiosngxxc",
				"nrzhywdplumeqvajtbtosngkxc",
				"wzzhyfdplomeqvdjtbiosngkxc",
				"urzhyfdplumeqvaatbiosngkxb",
				"wtzyyfdplumeqvajtbiosngkxl",
				"wrzhyfdhlumnqvajebiosngkxc",
				"wrzhyfdplumpqvajtbiosnyjxc",
				"wrzdyfdplumeqvajtviospgkxc",
				"wrzhyfdplzmeqvajtbiosegfxc",
				"wrzhyfdglumkqvajtwiosngkxc",
				"wrzhtfdplgmeqvaqtbiosngkxc",
				"wrzhyfdplumeqvajxpiosngexc",
				"frzhyfdplvmeqvajtbiosngkxp",
				"wrzhyfkplumeqvajtbfosngkpc",
				"irzhyfqplumeqvajtbiosngktc",
				"wrzhyfdpluvoqvajtbioingkxc",
				"wrzhyfdplumemvautbuosngkxc",
				"wfzhyflplumeqvijtbiosngkxc",
				"wrzhyfdglumeqvzjkbiosngkxc",
				"wrzcyfdplaneqvajtbiosngkxc",
				"wrzhbfdplumeqwajtbiosngpxc",
				"szdhyfdplumeqvajtbiosngkxc",
				"krzhyfdplumeqvajtxilsngkxc",
				"brzhyfmplumexvajtbiosngkxc",
				"wrzhyvdplumeqvajtbiosiglxc",
				"orzhyfdplumeqvaotbcosngkxc",
				"hrzhyfdplumeqvaptbiocngkxc",
				"wwzhyfdklummqvajtbiosngkxc",
				"wrzhyfdppymeqvvjtbiosngkxc",
				"wsehyudplumeqvajtbiosngkxc",
				"wrzhyzpplumeqvajtbioscgkxc",
				"wrzhyfqpyumeqvajtbiusngkxc",
				"urzhyfdpdumeqmajtbiosngkxc",
				"wrzhyfdrlumxqvajtbiosnakxc",
				"wrthyfdplumeskajtbiosngkxc",
				"wrzhyfdplymeqvajtbiesbgkxc",
				"wrzhyfdqlumeqyajtciosngkxc",
				"trzhsfdplumeqyajtbiosngkxc",
				"wpzhyfdplimeqvajtbiosngfxc",
				"wrzhhfdplrmeqvajtbiosngkxx",
				"wrzhycdpgumeqvajtbioslgkxc",
				"wrzhyfdelumeqvajgtiosngkxc",
				"wrzhyfdplutebvajtbiosygkxc",
				"wrzhyfdplukeqvajtbiorngkec",
				"erzhyfdilumeqvajwbiosngkxc",
				"wrzhyfdplumnivxjtbiosngkxc",
				"wrzhyfdplumebvajtoiovngkxc",
				"wrzhyfdplumeqvajtbtosnwkxe",
				"wrzhyfxplumevvajtciosngkxc",
				"wbzhyfdxlumeqvajtriosngkxc",
				"wrzyyfdplumeqvajmbiosngkxb",
				"wfthyfdplumeqvajtbiosngkdc",
				"wrzhuedplumeqvajtbgosngkxc",
				"wrzhifdplumeqvajtsrosngkxc",
				"wrzhyfdplumqqvajtaiosngkac",
				"krzhyfvvlumeqvajtbiosngkxc",
				"wrzhyfdplzmeqqajtbiosngkvc",
				"wrzhyfqplumeqvajtbiosngdxy",
				"wrzhyfdpluieqvajtbiosngjjc",
				"wrzhyfdvlumeqrajdbiosngkxc",
				"wrzhcfdpxumeqvajtbiotngkxc",
				"wrzhyfdprumeqvaitbiosngexc",
				"wrzhygdplumeqvpjtbiasngkxc",
				"wrzhyndplumeqvajtpiosngkoc",
				"wrzhyfdplumedvajtriowngkxc",
				"wezjyndplumeqvajtbiosngkxc",
				"wrmhyfdplumewiajtbiosngkxc",
				"wrztyfdplumeqnajtbiobngkxc",
				"wrzhyfdpyumeqvajjbijsngkxc",
				"wrfhyfdplumeqkajtbiosnqkxc",
				"wrzhyfdpllmezvartbiosngkxc",
				"wszhyfdplumeqeajtbiqsngkxc",
				"wrzhyfdplumeqwajtbnosnikxc",
				"wrzvyfqulumeqvajtbiosngkxc",
				"drzhyfdplureqvajtbiqsngkxc",
				"wrzhyfdplumeqjamtbigsngkxc",
				"wrzhyfdplumeqvajbbiosngzrc",
				"grzhyfdpuumeqvajtbicsngkxc",
				"wrrhyfdplumeqvajtgiosnggxc",
				"wrzhyfkplumvqvajtbiosnhkxc",
				"wrzhyfdplumeqvajtbicspgkxa",
				"wrzhyfdplumeqvajtiiosnggoc",
				"wfzhyfdplumyqvaytbiosngkxc",
				"wrzhyfdpcumeqvajtbibsnfkxc",
				"wrzhyfdplumeqvajtbigsnzkmc",
				"wrzhyfdplcmeqvqjtriosngkxc",
				"wrzhypdplwmeqvajtbiosnvkxc",
				"wrziyfdmlumeqvaatbiosngkxc",
				"wkzhyfdplsmeqvajobiosngkxc",
				"wrzhyfdplumeqvkjvliosngkxc",
				"wzzbyfdplumeqvajtbiolngkxc",
				"wrzhyfdplvweqvajtbipsngkxc",
				"wrzhyvdplumeqvujtbiosnfkxc",
				"wrbhyfdplumedvajtbiosnhkxc",
				"wrzhofdplumeqvajtbiosnskxy",
				"wrzhyfdplumeqvaetbiohwgkxc",
				"wezhyfoplumeqvajtbiosngmxc",
				"wrzhykdblumeqvajtbiosngkjc",
				"wrzhyddplwmeqvajtbioungkxc",
				"wrzhyldplumqqvajpbiosngkxc",
				"wrzhyfdtlumeqvajtbiusngkcc",
				"wrzhyfdilumeqvajtbiosdgkxk",
				"wrvhywdplumeqvajtbiosngoxc",
				"wrzhyfdpyumeqvajtkiomngkxc",
				"wrzhyfdpbummqvajtbiosngcxc",
				"wrzhyfdpljmeqvajlbiosngjxc",
				"wrzhyfdpmuieqdajtbiosngkxc",
				"wrzgrfdplumeqvaktbiosngkxc",
				"wrzhgrdpluueqvajtbiosngkxc",
				"wazhyfdplhmeqvaqtbiosngkxc",
				"wruhyfdplumeqvujtliosngkxc",
				"wrzvyfdslumeqvajtbiwsngkxc",
				"wrzhyfdplumeivactbiosqgkxc",
				"wrzpyfdpbumeqvajtbioszgkxc",
				"bgzhyfdplumeyvajtbiosngkxc",
				"wrzhyfkplumeqvajtbiotngkxh",
				"wrdhyfhplumexvajtbiosngkxc",
				"brzhyfdpgumeqvgjtbiosngkxc",
				"arzhqfdpeumeqvajtbiosngkxc",
				"wrzhyftplumeqvajfbiosnykxc",
				"wrzhyfdpcumeqvartbtosngkxc",
				"wrzhvfzplumdqvajtbiosngkxc",
				"wrzhyfdjlumeqvaetbiosjgkxc",
				"wrbhyfdplumeqvajjjiosngkxc",
				"wrxhyfdplumeqvajtbiyskgkxc",
				"wpzhyydplumeqvajtbiosqgkxc",
				"wrzhyfdplumzqvajtbzoongkxc",
				"crzhyfdplnmeqvajtbjosngkxc",
				"wrzhyfdpluveusajtbiosngkxc",
				"wrzhypdpluyecvajtbiosngkxc",
				"wrnhyfdplumeqvajtbioengoxc",
				"wrzhypdplumefvajybiosngkxc",
				"wrzhyfdplumeqvattviosngkdc",
				"wrzhyfdplqmeqbajtbiostgkxc",
				"wrghyfdpluveqvajtbiosngkxn",
				"wryhyfdplumeqvajrbiopngkxc",
				"wrzhyqdplumeqvajtbiwsngkxt",
				"wrmoyfdpluheqvajtbiosngkxc",
				"wrghyfdnlumeqvyjtbiosngkxc",
				"wrzpyfdplumevvaatbiosngkxc",
				"wrzhyfdplumhqvajtbiodngxxc",
				"wrzhyfdplumeqcajtbioyjgkxc",
				"wrzhyfdplumeqvajabirsngkgc",
				"wrzhtfnplukeqvajtbiosngkxc",
				"wqzhyfdplumeqvajtbiopegkxc",
				"lrzhzfdplumeqdajtbiosngkxc",
				"wrzzyfdplumeqvajnkiosngkxc",
				"wrzhyfdflmmeqvajmbiosngkxc",
				"wrzoyfdplumeqvjjtpiosngkxc",
				"wrzhyfdpmpmeqvajhbiosngkxc",
				"krvhyfdplumeqvajtbiossgkxc",
				"wrzhyfdplumeqvaetviosnmkxc",
				"wrzhyfzclumeqvajtbiosngwxc",
				"wrzhyfdpvumeqvajtbiosngkcv",
				"wrzhyfdpoumeqvajtbiozngoxc",
				"wrzhyfwglumeqvajtbxosngkxc",
				"wrshyfdplumeqiajtbiosngklc",
				"wrzhyfdptdmeqvajtziosngkxc",
				"wrwhyfdplumeqqajtbiosngkxj",
				"wrzlyfypldmeqvajtbiosngkxc",
				"wrzhyfdplumeqvajtbirknikxc",
				"wrzhyhdplumeqvajtbmosnbkxc",
				"wyzhyfiplumeqvwjtbiosngkxc",
				"wrzgyfsplumeqvajtziosngkxc",
				"wrzhrfdllumepvajtbiosngkxc",
				"wrzayfdplumeqvajtbiosqgktc",
				"whzhyfdplemnqvajtbiosngkxc",
				"wazhyfdplumeqvaptbioongkxc",
				"wrzhyfdpluueqvajtbiosnglvc",
				"wrzhyfdplumjqvajmbionngkxc",
				"wrzhofdplvmeqvajtbiosnqkxc",
				"wrzhfidpluzeqvajtbiosngkxc",
				"wrzhlfdpcumeqvaatbiosngkxc",
				"wrzhyfdplumewvajtbiosigkoc",
				"wrzjyfdplwmeqvajtbiodngkxc",
				"wrzhyfdplumeqnsjtniosngkxc",
				"wrzxyfdplxmeqvajtbiosngkdc",
				"wrzhyfdplumpqvartbuosngkxc",
				"orzhyfdplumeqzsjtbiosngkxc",
				"wrzhyfdplumebvawtbiosngkxt",
				"wrztyfdulumeqvajtbiosngkxy",
				"wrzhytdplumeqvajtbznsngkxc",
				"wrzhvfdplumeqvajtbinsngkxu",
				"wezmyfdplumeqvajhbiosngkxc",
				"wrzhhftplumeqvajtaiosngkxc",
				"wrzhyfgplumeqvajtbioskgjxc",
				"ujuhyfdplumeqvajtbiosngkxc",
				"wryhymdplumeqvaftbiosngkxc",
				"wrzhygdplumeqvajibiosfgkxc",
				"frzhyfdppumeqvavtbiosngkxc",
				"wruhyfdylumeqvajzbiosngkxc",
				"wrzhzfdplumeqvajtbwosygkxc",
				"wrzhyfdplumeqvaeteiojngkxc",
				"wrhhyfdplumeqvajtiiopngkxc",
				"irzhyfdplumeqvajtbiosngryc",
				"wrvhycdpzumeqvajtbiosngkxc",
				"wrzhyfdplumyqwajtboosngkxc",
				"wrzthfdplumeqvajtbioengkxc",
				"mrzhyfdalumeqvajtbiosngcxc",
				"wrzhyfdflumpqvajtbiosngkmc",
				"wrzhyfxplumeqvajtbiosnvkxo",
				"wrzhyfdglumeqvajtbiosnfkxu",
				"wrzhyfdnrumeqpajtbiosngkxc",
				"wrzhlipplumeqvajtbiosngkxc",
				"wrzhkfdplumemvajtbiohngkxc",
				"wrziyfdmlumeqvaatbiosngkoc",
				"wrzhyfdplwceqvajtbiosngzxc",
				"wrzhyfdplumpqvactbiosngixc",
				"wdzhyfdhdumeqvajtbiosngkxc",
				"wnzhyfdplumeqvajtbbosngrxc",
				"wrzhyfdblumeqvajtbiosngvxw",
				"wyzhyfxpkumeqvajtbiosngkxc",
				"wrzhywdplumjqvajgbiosngkxc",
				"wrzhyfdpxumhqvajtbiokngkxc",
				"wrzhxfpplumeqvajtbiosngkxk",
				"mrzhyfdplumeqkajubiosngkxc",
				"drzhyfdplumeqvajtbioingnxc",
				"wrekyfdplumeqvajtbidsngkxc",
				"wrzhyfdplumeanyjtbiosngkxc",
				"wrzhyddpluzeqvajtbiosngtxc",
				"wrzfyfdplumeqvaqtbiosngkxr",
				"wrghywdpluneqvajtbiosngkxc",
				"wrzhyfdplueeqvaptbioyngkxc",
				"wrzhyqdpllmeqvajtbiosngdxc",
				"whzhyfdxlumeqvajtbiosngksc",
				"wrzjyfdplumeqvuitbiosngkxc",
				"brzhyfdplumeqhajtbiolngkxc",
				"wrzhyfqclureqvajtbiosngkxc",
				"wwzhpfdplureqvajtbiosngkxc",
				"wrzhyfdplumeqvavebijsngkxc",
				"wrzhyfdpuumeqvajtsiosnkkxc",
				"wrxhyfuplumeqvajtbiosngpxc",
				"wrzhyfdplumeqvujlbiospgkxc",
				"wrzvyfdplumeqvajtbiwsngpxc",
				"wrzhyndplumeqvajtbiwsnekxc",
				"wrzhkfdpoumeqvautbiosngkxc");
	}
}
