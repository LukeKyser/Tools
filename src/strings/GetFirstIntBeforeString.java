package strings;

import java.util.ArrayList;

public class GetFirstIntBeforeString {

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<log>\n" +
                        "    <entry id=\"1\">\n" +
                        "        <message>Application started</message>\n" +
                        "    </entry>\n" +
                        "    <entry id=\"52\">\n" +
                        "        <message>Application ended</message>\n" +
                        "    </entry>\n" +
                        "    <entry id=\"1\">\n" +
                        "        <message>Application started</message>\n" +
                        "    </entry>\n" +
                        "    <entry id=\"9876\">\n" +
                        "        <message>Application ended</message>\n" +
                        "    </entry>\n" +
                        "    <entry id=\"1\">\n" +
                        "        <message>Application started</message>\n" +
                        "    </entry>\n" +
                        "    <entry id=\"3452\">\n" +
                        "        <message>Application ended</message>\n" +
                        "    </entry>\n" +
                        "    <entry id=\"1\">\n" +
                        "        <message>Application started</message>\n" +
                        "    </entry>\n" +
                        "    <entry id=\"7116\">\n" +
                        "        <message>Application ended</message>\n" +
                        "    </entry>\n" +
                        "</log>";

        ArrayList<Integer> ids = getIdsByMessage(xml, "Application ended", null);
        for (int id : ids)
            System.out.println(id);
    }

    public static ArrayList<Integer> getIdsByMessage(String xml, String message, ArrayList<Integer> ids) throws Exception {
        if(!xml.contains(message)){
            return ids;
        }
        if(ids == null){
            ids = new ArrayList() {};
        }
        int messageIndex = xml.indexOf(message);
        int i = 1;
        int j = 1;

        while(!Character.isDigit(xml.charAt(messageIndex - i))){
            i++;
        }

        while(Character.isDigit(xml.charAt(messageIndex - i - j))){
            j++;
        }
        int numIndex = messageIndex - i - j + 1;
        String strNum = "";

        // Added chars to one string
        for(int k = numIndex; k <= messageIndex - i; k++){
            strNum += xml.charAt(k);
        }

        ids.add(Integer.parseInt(strNum));
        xml = xml.substring(messageIndex + message.length(), xml.length());
        ids = getIdsByMessage(xml, message, ids);

        return ids;
    }
}
