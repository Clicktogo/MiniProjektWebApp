package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OldConcertRepository {

    List<Concert> concerts;
    /*
        public OldConcertRepository() {
            concerts = new ArrayList<>();
            basicConcerts();
        }

        public void basicConcerts() {
            concerts.add(new Concert(1, "Iron Maiden", "12/8", 1099, new Arena("Ullevi", "Ullevigatan", "Göteborg", 75000), "Iron Maiden är ett engelskt heavy metal-band som bildades den 25 december 1975 av Steve Harris, basist och huvudsaklig låtskrivare. Iron Maidens låtar är " +
                    "ofta progressiva med mycket melodier och tempobyten, och texterna har ofta ett skönlitterärt, historiskt eller filmiskt tema. Bandet är ett av de mest inflytelserika och framgångsrika inom musikgenren heavy metal och har sålt cirka 100 miljoner album. " +
                    "Sedan albumdebuten 1980 har bandet haft tre olika sångare, fyra olika gitarrister och två olika trummisar. Innan albumdebuten förekom ytterligare tretton kortvariga medlemmar."));
            concerts.add(new Concert(2, "Veronica Maggio", "12/9", 699, new Arena("Nalen", "Regeringsgatan", "Stockholm", 500), "Sedan albumdebuten 2006 " +
                    "har Maggio utvecklats till en av 2010-talets mest framgångsrika svenska popartister. Hennes diskografi består av sex studioalbum och sjutton singlar. Sedan albumdebuten 2006 har Maggio utvecklats till en av 2010-talets mest framgångsrika svenska popartister. " +
                    "2011 års Satan i gatan, med singeln \"Jag kommer\", blev ett av årets svenska musikalbum. Även uppföljarna Handen i fickan fast jag bryr mig och Den första är alltid gratis har nått stora listframgångar. Tio av hennes singlar har blivit svenska listettor, och totalt har singlar eller album 25 gånger nått guld- eller platinastatus."));
            concerts.add(new Concert(3, "Zara Larsson", "12/10", 899, new Arena("Globen", "Arenavägen", "Stockholm", 16000), "Zara Larsson slog först igenom i TV4:s Talang 2008 som tioåring där hon vann finalen " +
                    "med låten \"My Heart Will Go On\" och fick ge ut låten som singel. Larsson kontrakterades av skivbolaget TEN Music Group 2012 och gav ut sin debut-EP, Introducing, i januari 2013. Singeln \"Uncover\" toppade landslistorna i både Sverige och Norge, men tog sig även upp till topp " +
                    "tio på flera europeiska listor. På Rockbjörnen i augusti 2013 vann Larsson två priser: \"Årets genombrott\" och \"Årets kvinnliga liveartist\" och blev den yngsta artist som vunnit två Rockbjörnar."));
            concerts.add(new Concert(4, "Mustasch", "12/11", 1459, new Arena("Bern Arena", "Restalundsvägen", "Örebro", 12000), "Mustasch är ett svenskt hårdrocksband från Göteborg som bildades 1998. " +
                    "Bandets debutalbum, Above All, gavs ut 2002. Mustasch vann en grammis 2007 i kategorin Årets hårdrock för albumet Latest Version of the Truth och en till 2008 för det självbetitlade albumet Mustasch. 2018 kom albumet Silent Killer med singlarna Lawbreaker, Fire och Winners, vilket var den första skivan med nutida trummisen Robban Bäck."));
            concerts.add(new Concert(5, "Timbuktu", "12/12", 2992, new Arena("Berns", "Berzelii park", "Stockholm", 50), "Jason Michael Bosak Diakité, mer känd under sitt artistnamn Timbuktu, född 11 januari 1975 i Lund, " +
                    "är en svensk hip-hopartist, rappare och programledare av amerikansk börd. Han har tagit sitt artistnamn från staden Timbuktu i Mali, ett land där hans fars släkt har rötter. Jason Diakité har haft flera egna radioprogram i P3: P3 Hiphop, " +
                    "Jasons värld och Jasons spellista. Mellan 2009 och 2012 var Diakité programledare i tv- och radioprogrammet Musikhjälpen där han medverkade till insamling för välgörande ändamål."));
            concerts.add(new Concert(6, "Plura", "1/8", 456, new Arena("Malmö arena", "Arenagatan", "Malmö", 13000), "Per Malte Lennart \"Plura\" Jonsson, " +
                    "född 10 augusti 1951 i Norrköping, är en svensk låtskrivare, sångare, gitarrist och författare. Han var med och grundade bandet Eldkvarn och har varit programledare i TV. En av Pluras stora inspirationskällor, som bidrog mycket till att han intresserade sig för musik, " +
                    "var John Mayalls skiva A Hard Road (1967). Hans egna texter var till en början inte så djupa. Sin inspiration hämtar han både från sitt vuxenliv med personliga relationer och problem, men också från barndomen och uppväxten i Norrköping."));
            concerts.add(new Concert(7, "Aya Nakamura", "12/9", 900, new Arena("Hovet", "Arenaslingam", "Stockholm", 8000), "Aya Nakamura is a French-Malian pop singer. " +
                    "She is best known for her hit song \"Djadja\" that has more than 700 million views on YouTube. She was born in Bamako and immigrated to France with her family. Coming from a family of griots (West African storytellers, praise singers / poets of oral tradition)."));
            concerts.add(new Concert(8, "Ed Sheeran", "3/10", 1300, new Arena("Berns", "Berzelii park", "Stockholm", 300), "Ed Sheeran har sålt mer än 150 miljoner skivor i hela världen, " +
                    "vilket gjort honom till en av världens mest framgångsrika artister någonsin. Han har 84,5 miljoner RIAA-certifierade enheter i USA, och två av hans album är listade som några tav de bäst säljande albumen i Storbritanniens historia  I december 2019 angav Official Charts Company honom som den största artisten det årtiondet. " +
                    "Globalt har Spotify gett honom titeln som den andra mest spelade artisten under årtiondet och den mest spelade artisten någonsin."));
            concerts.add(new Concert(9, "Maleek Berry", "6/7", 750, new Arena("Malmö arena", "Arenagatan", "Malmö", 13000), "Maleek Berry, is a British-Nigerian " +
                    "record producer and recording artist.[2] After his break into the spotlight in 2012, Maleek Berry was nominated as \"Music Producer of the Year\" at the 2014 Nigeria Entertainment Awards. In 2017 he was nominated in the Best Male category of the annual MOBO Awards."));
            concerts.add(new Concert(10, "Robyn", "12/9", 900, new Arena("Hovet", "Arenaslingam", "Stockholm", 8000), "Robin Miriam Carlsson, mer känd under sitt artistnamn " +
                    "Robyn, är en svensk popsångerska, låtskrivare, musikproducent och DJ. I februari 2020 utsågs Robyn som mottagare av den unika utmärkelsen \"2010-talets främsta låtskrivare\" på den brittiska musiktidningen New Musical Express (NME) årliga prisgala. 2010-talets bästa låt ansågs av tidningen vara hennes \"Dancing on My Own\"."));
            concerts.add(new Concert(11, "Lizzo", "3/11", 900, new Arena("Berns", "Berzelii park", "Stockholm", 300), "Lizzo is an American singer, rapper, songwriter, and flutist. Born in Detroit, Michigan. " +
                    "In 2019, Time named Lizzo as \"Entertainer of the Year\" for her meteoric rise and contribution to music. In addition to her three Grammy Awards, she has also won a Billboard Music Award, a BET Award, and two Soul Train Music Awards."));
            concerts.add(new Concert(12, "Deorro", "28/7", 750, new Arena("Malmö arena", "Arenagatan", "Malmö", 13000), "Deorro, is an American DJ signed to Ultra Records. He formerly used the name TON!C. " +
                    "In December 2014, he released the single \"Perdoname\", which achieved success in Poland after its appearance in Microsoft Windows TV commercial. In March 2015, he released a third version of \"Five Hours\" with Chris Brown, titled \"Five More Hours\". The song has charted in Ireland, the Netherlands, and Sweden. " +
                    "On 31 March 2017, Deorro released his debut album, Good Evening, which features 26 tracks, including his new single \"Rise and Shine\"."));
        }
    */
    public void addConcert(Concert concert) {
        concerts.add(concert);
    }

    public List<Concert> getConcerts() {
        return concerts;
    }
}
