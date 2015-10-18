#####Aihekuvaus
**Sukupuu** 
Ohjelma piirtää sukupuun käyttäjän antaman syötteen perusteella (graafinen käyttöliittymä). Miespuoliset piirretään neliöinä ja naispuoliset ympyröinä. Sukupuussa tulevat näkymään periytyvä sairaus/ominaisuus kuvion värin perusteella, eli värillinen on sairas ja väritön/valkoinen terve. Ohjelma on tarkoitettu suhteellisen pienille suvuille, esim. 3 sukupolvea, 10 henkilöä (eikä sisäsiittoisuutta). Kuvioiden väleille piirretään viivat sukulaisuussuhteiden mukaan. Kuvioiden alle tulee henkilön nimi. 
#####Käyttäjät
Genetiikan opiskelijat, tutkijat jne., jotka tarvitsevat kuvan sukupuusta vaikka julkaisua tai tutkielmaa varten.
####Ohjelman toiminta
Ohjelman käynnistys avaa ikkunan, johon syötetään henkilöiden tietoja: nimi (pakollinen), ikä, sukupuoli, mutaatiot ja se, onko henkilö sairas vai terve. Henkilön puolisolle ja lapsille on myös omat kentät. (Huom! Puoliso tarkoittaa tässä yhteydessä yhteisen lapsen toista vanhempaa). Henkilöiden tiedot syötetään henkilö kerrallaan ja aina yksi sukupolvi kerrallaan. Kun kaikki henkilöt on syötetty, henkilöistä muodostetaan Henkilo-oliot, jotka talletetaan listaan. Tämä lista syötetään piirustuslogiikkaan, joka luo piirrettävät kuviot. Miespuolisesta henkilöstä luodaan siis neliö ja naispuolisesta ympyrä. Kuvion y-koordinaatin määrää henkilön sukupolvi. X-koordinaatin laskemisessa huolehditaan että puolisot tulevat vierekkäin ja sisarukset samoin. Viivat luodaan puolisoiden välille sekä puolisoista lapsiin. Piirustuslogiikka myös määrittelee kuvion värin (musta): jos henkilö on sairas, kuvio saa värin ja jos ei ole, kuvio jää värittömäksi. Kaikki luodut kuviot talletetaan listaan, joka palautetaan Ohjelmalogiikkaan.
Ohjelmalogiikka luo PiirtoKayttoLiittyma-olion, jolle annetaan parametrina kuviolista sekä tieto henkilöiden nimistä koordinaatteineen. PiirtoKayttoLiittyma luo Piirustusalustan, jossa varsinainen piirtäminen tapahtuu. Aukeaa uusi ikkuna, jossa piirretty sukupuu sekä henkilöiden nimet kuvioiden alla.

**Puutteet**
Sukupuukuvioon oli tarkoitus saada kuvioiden alle henkilön nimen lisäksi henkilön ikä sekä henkilön kantamat mutaatiot. Loppukuvassa olisi kiva olla myös sukupolvien numerot, jonkinlainen selitelaatikko jne. Piirustuslogiikan kehittämiseen meni kuitenkin niin paljon aikaa, että edellä mainitut jäivät toteuttamatta. 
Sukupuolta "MUU" ei myöskään nyt tueta. "MUU" pitäisi tuottaa vinoneliö-kuvion, jonka luomiseen myöskään jäänyt aikaa. Nyt "MUU" tulkitaan miespuoliseksi.

**Jatkokehitysideat**
Sairaus/ominaisuus useammalle sairaudelle: kuviossa olisi väri puoliksi (tai vaikka neljälle ominaisuudelle 1/4 kuviosta)
Voisi olla kätevää jos henkilöiden tiedot voisi lukea suoraan tiedostosta, varsinkin jos henkilöitä on paljon.
Export-toiminto, jolla loppukuvan saisi tallennettua.

**Tausta**
Sukupuiden perussymbolit: http://cancergenome.nih.gov/Common/PopUps/popImage.aspx?imageName=/images/cdr/Live/CDR613538-750.jpg&caption=Standard%20pedigree%20nomenclature.%20Common%20symbols%20are%20used%20to%20draw%20a%20pedigree%20%28family%20tree%29.%20A%20pedigree%20shows%20relationships%20between%20family%20members%20and%20patterns%20of%20inheritance%20for%20certain%20traits%20and%20diseases.
