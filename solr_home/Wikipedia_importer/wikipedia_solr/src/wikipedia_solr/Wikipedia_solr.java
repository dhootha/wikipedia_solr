/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wikipedia_solr;

import java.io.IOException;

import de.tudarmstadt.ukp.wikipedia.api.exception.WikiApiException;
import de.tudarmstadt.ukp.wikipedia.parser.ParsedPage;
import de.tudarmstadt.ukp.wikipedia.parser.Paragraph;

import de.tudarmstadt.ukp.wikipedia.parser.Section;
import de.tudarmstadt.ukp.wikipedia.parser.mediawiki.MediaWikiParser;
import de.tudarmstadt.ukp.wikipedia.parser.mediawiki.MediaWikiParserFactory;
import wikipedia_solr.SimpleParser;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patrickmullen
 */
public class Wikipedia_solr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String documentText = de.tudarmstadt.ukp.wikipedia.parser.tutorial.TestFile.getFileText();
  /*
        String documentText2 = "'''Anarchism''' is generally defined as the [[political philosophy]] which holds the [[state (polity)|state]] to be undesirable, unnecessary, and harmful,&lt;ref name=&quot;definition&quot;&gt;"+
    "{{Cite journal|last=Malatesta|first=Errico|title=Towards Anarchism|journal=MAN!|publisher=International Group of San Francisco|location=Los Angeles|oclc=3930443|url=http://www.marxists.org/archive/malatesta/1930s/xx/toanarchy.htm|authorlink=Errico Malatesta}}"+
"{{Cite journal|url=http://www.theglobeandmail.com/servlet/story/RTGAM.20070514.wxlanarchist14/BNStory/lifeWork/home/"+
"|title=Working for The Man |journal=[[The Globe and Mail]] |accessdate=2008-04-14 |last=Agrell |first=Siri |date=2007-05-14}}"+
"{{cite web|url=http://www.britannica.com/eb/article-9117285|title=Anarchism|year=2006|work=Encyclopædia Britannica|publisher=Encyclopædia Britannica Premium Service|accessdate=2006-08-29}}"+
"{{Cite journal|year=2005|title=Anarchism|journal=The Shorter [[Routledge Encyclopedia of Philosophy]]|page=14|quote=Anarchism is the view that a society without the state, or government, is both possible and desirable.}}"+
"The following sources cite anarchism as a political philosophy:"+
"{{Cite book| last = Mclaughlin | first = Paul | title = Anarchism and Authority | publisher = Ashgate | location = Aldershot | year = 2007 | isbn = 0-7546-6196-2 |page=59}}"+
"{{Cite book| last = Johnston | first = R. | title = The Dictionary of Human Geography | publisher = Blackwell Publishers | location = Cambridge | year = 2000 | isbn = 0-631-20561-6 |page=24}}&lt;/ref&gt;&lt;ref name=slevin&gt;Slevin, Carl. &quot;Anarchism.&quot; ''The Concise Oxford Dictionary of Politics''. Ed. Iain McLean and Alistair McMillan. Oxford University Press, 2003.&lt;/ref&gt; or alternatively as opposing [[authority]] and [[hierarchical organization]] in the conduct of human relations.&lt;ref name=&quot;iaf-ifa.org&quot;&gt;&quot;The [[International of Anarchist Federations|IAF - IFA]] fights for : the abolition of all forms of authority whether economical, political, social, religious, cultural or sexual.&quot;[http://www.iaf-ifa.org/principles/english.html &quot;Principles of The [[International of Anarchist Federations]]&quot;]&lt;/ref&gt;&lt;ref&gt;&quot;Anarchism, then, really stands for the liberation of the human mind from the dominion of religion; the liberation of the human body from the dominion of property; liberation from the shackles and restraint of government. Anarchism stands for a social order based on the free grouping of individuals for the purpose of producing real social wealth; an order that will guarantee to every human being free access to the earth and full enjoyment of the necessities of life, according to individual desires, tastes, and inclinations.&quot; [[Emma Goldman]]. &quot;What it Really Stands for Anarchy&quot; in ''[[Anarchism and Other Essays]]''.&lt;/ref&gt;&lt;ref&gt;Individualist anarchist Benjamin Tucker defined anarchism as opposition to authority as follows &quot;They found that they must turn either to the right or to the left, — follow either the path of Authority or the path of Liberty. Marx went one way; Warren and Proudhon the other. Thus were born State Socialism and Anarchism...Authority, takes many shapes, but, broadly speaking, her enemies divide themselves into three classes: first, those who abhor her both as a means and as an end of progress, opposing her openly, avowedly, sincerely, consistently, universally; second, those who profess to believe in her as a means of progress, but who accept her only so far as they think she will subserve their own selfish interests, denying her and her blessings to the rest of the world; third, those who distrust her as a means of progress, believing in her only as an end to be obtained by first trampling upon, violating, and outraging her. These three phases of opposition to Liberty are met in almost every sphere of thought and human activity. Good representatives of the first are seen in the Catholic Church and the Russian autocracy; of the second, in the Protestant Church and the Manchester school of politics and political economy; of the third, in the atheism of Gambetta and the socialism of the socialism off Karl Marg.&quot; [[Benjamin Tucker]]. [http://www.theanarchistlibrary.org/HTML/Benjamin_Tucker__Individual_Liberty.html ''Individual Liberty.'']&lt;/ref&gt;&lt;ref name=&quot;Ward 1966&quot;&gt;{{cite web|url=http://www.panarchy.org/ward/organization.1966.html|last=Ward|first=Colin|year=1966|title=Anarchism as a Theory of Organization|accessdate=1 March 2010}}&lt;/ref&gt;&lt;ref&gt;Anarchist historian [[George Woodcock]] report of [[Mikhail Bakunin]]'s anti-authoritarianism and shows opposition to both state and non-state forms of authority as follows: &quot;All anarchists deny authority; many of them fight against it.&quot; (pg. 9)...Bakunin did not convert the League's central committee to his full program, but he did persuade them to accept a remarkably radical recommendation to the Berne Congress of September 1868, demanding economic equality and implicitly attacking authority in both Church and State.&quot;&lt;/ref&gt;&lt;ref&gt;{{Cite book|last=Brown |first=L. Susan |chapter=Anarchism as a Political Philosophy of Existential Individualism: Implications for Feminism |title=The Politics of Individualism: Liberalism, Liberal Feminism and Anarchism |publisher=Black Rose Books Ltd. Publishing |year= 2002 |page=106}}&lt;/ref&gt; Proponents of anarchism, known as &quot;anarchists&quot;, advocate [[stateless society|stateless societies]] based on non-[[Hierarchy|hierarchical]]&lt;ref name=&quot;iaf-ifa.org&quot;/&gt;&lt;ref&gt;&quot;That is why Anarchy, when it works to destroy authority in all its aspects, when it demands the abrogation of laws and the abolition of the mechanism that serves to impose them, when it refuses all hierarchical organization and preaches free agreement — at the same time strives to maintain and enlarge the precious kernel of social customs without which no human or animal society can exist.&quot; [[Peter Kropotkin]]. [http://www.theanarchistlibrary.org/HTML/Petr_Kropotkin__Anarchism__its_philosophy_and_ideal.html Anarchism: its philosophy and ideal]&lt;/ref&gt;&lt;ref&gt;&quot;anarchists are opposed to irrational (e.g., illegitimate) authority, in other words, hierarchy — hierarchy being the institutionalisation of authority within a society.&quot; [http://www.theanarchistlibrary.org/HTML/The_Anarchist_FAQ_Editorial_Collective__An_Anarchist_FAQ__03_17_.html#toc2 &quot;B.1 Why are anarchists against authority and hierarchy?&quot; in [[An Anarchist FAQ]]]&lt;/ref&gt; [[voluntary association]]s.&lt;ref&gt;&quot;ANARCHISM, a social philosophy that rejects authoritarian government and maintains that voluntary institutions are best suited to express man’s natural social tendencies.&quot; George Woodcock. &quot;Anarchism&quot; at The Encyclopedia of Philosophy&lt;/ref&gt;&lt;ref&gt;&quot;In a society developed on these lines, the voluntary associations which already now begin to cover all the fields of human activity would take a still greater extension so as to substitute themselves for the state in all its functions.&quot; [http://www.theanarchistlibrary.org/HTML/Petr_Kropotkin___Anarchism__from_the_Encyclopaedia_Britannica.html [[Peter Kropotkin]]. “Anarchism” from the Encyclopædia Britannica]&lt;/ref&gt;";
*/
        String documentText2 = "'''Anarchism''' is generally defined as the [[political philosophy]] which holds the [[state (polity)|state]] to be undesirable, unnecessary, and harmful, <ref name=\"definition\">"+
    "{{Cite journal|last=Malatesta|first=Errico|title=Towards Anarchism|journal=MAN!|publisher=International Group of San Francisco|location=Los Angeles|oclc=3930443|url=http://www.marxists.org/archive/malatesta/1930s/xx/toanarchy.htm|authorlink=Errico Malatesta}}"+
"{{Cite journal|url=http://www.theglobeandmail.com/servlet/story/RTGAM.20070514.wxlanarchist14/BNStory/lifeWork/home/"+
"|title=Working for The Man |journal=[[The Globe and Mail]] |accessdate=2008-04-14 |last=Agrell |first=Siri |date=2007-05-14}}"+
"{{cite web|url=http://www.britannica.com/eb/article-9117285|title=Anarchism|year=2006|work=Encyclopædia Britannica|publisher=Encyclopædia Britannica Premium Service|accessdate=2006-08-29}}"+
"{{Cite journal|year=2005|title=Anarchism|journal=The Shorter [[Routledge Encyclopedia of Philosophy]]|page=14|quote=Anarchism is the view that a society without the state, or government, is both possible and desirable.}}"+
"The following sources cite anarchism as a political philosophy:"+
"{{Cite book| last = Mclaughlin | first = Paul | title = Anarchism and Authority | publisher = Ashgate | location = Aldershot | year = 2007 | isbn = 0-7546-6196-2 |page=59}}"+
"{{Cite book| last = Johnston | first = R. | title = The Dictionary of Human Geography | publisher = Blackwell Publishers | location = Cambridge | year = 2000 | isbn = 0-631-20561-6 |page=24}}</ref><ref name=slevin>Slevin, Carl. &quot;Anarchism.&quot; ''The Concise Oxford Dictionary of Politics''. Ed. Iain McLean and Alistair McMillan. Oxford University Press, 2003.</ref> or alternatively as opposing [[authority]] and [[hierarchical organization]] in the conduct of human relations.<ref name=\"iaf-ifa.org\">The [[International of Anarchist Federations|IAF - IFA]] fights for : the abolition of all forms of authority whether economical, political, social, religious, cultural or sexual.&quot;[http://www.iaf-ifa.org/principles/english.html &quot;Principles of The [[International of Anarchist Federations]]&quot;]&lt;/ref&gt;&lt;ref&gt;&quot;Anarchism, then, really stands for the liberation of the human mind from the dominion of religion; the liberation of the human body from the dominion of property; liberation from the shackles and restraint of government. Anarchism stands for a social order based on the free grouping of individuals for the purpose of producing real social wealth; an order that will guarantee to every human being free access to the earth and full enjoyment of the necessities of life, according to individual desires, tastes, and inclinations.&quot; [[Emma Goldman]]. &quot;What it Really Stands for Anarchy&quot; in ''[[Anarchism and Other Essays]]''.&lt;/ref&gt;&lt;ref&gt;Individualist anarchist Benjamin Tucker defined anarchism as opposition to authority as follows &quot;They found that they must turn either to the right or to the left, — follow either the path of Authority or the path of Liberty. Marx went one way; Warren and Proudhon the other. Thus were born State Socialism and Anarchism...Authority, takes many shapes, but, broadly speaking, her enemies divide themselves into three classes: first, those who abhor her both as a means and as an end of progress, opposing her openly, avowedly, sincerely, consistently, universally; second, those who profess to believe in her as a means of progress, but who accept her only so far as they think she will subserve their own selfish interests, denying her and her blessings to the rest of the world; third, those who distrust her as a means of progress, believing in her only as an end to be obtained by first trampling upon, violating, and outraging her. These three phases of opposition to Liberty are met in almost every sphere of thought and human activity. Good representatives of the first are seen in the Catholic Church and the Russian autocracy; of the second, in the Protestant Church and the Manchester school of politics and political economy; of the third, in the atheism of Gambetta and the socialism of the socialism off Karl Marg.&quot; [[Benjamin Tucker]]. [http://www.theanarchistlibrary.org/HTML/Benjamin_Tucker__Individual_Liberty.html ''Individual Liberty.'']&lt;/ref&gt;&lt;ref name=&quot;Ward 1966&quot;&gt;{{cite web|url=http://www.panarchy.org/ward/organization.1966.html|last=Ward|first=Colin|year=1966|title=Anarchism as a Theory of Organization|accessdate=1 March 2010}}&lt;/ref&gt;&lt;ref&gt;Anarchist historian [[George Woodcock]] report of [[Mikhail Bakunin]]'s anti-authoritarianism and shows opposition to both state and non-state forms of authority as follows: &quot;All anarchists deny authority; many of them fight against it.&quot; (pg. 9)...Bakunin did not convert the League's central committee to his full program, but he did persuade them to accept a remarkably radical recommendation to the Berne Congress of September 1868, demanding economic equality and implicitly attacking authority in both Church and State.&quot;&lt;/ref&gt;&lt;ref&gt;{{Cite book|last=Brown |first=L. Susan |chapter=Anarchism as a Political Philosophy of Existential Individualism: Implications for Feminism |title=The Politics of Individualism: Liberalism, Liberal Feminism and Anarchism |publisher=Black Rose Books Ltd. Publishing |year= 2002 |page=106}}&lt;/ref&gt; Proponents of anarchism, known as &quot;anarchists&quot;, advocate [[stateless society|stateless societies]] based on non-[[Hierarchy|hierarchical]]&lt;ref name=&quot;iaf-ifa.org&quot;/&gt;&lt;ref&gt;&quot;That is why Anarchy, when it works to destroy authority in all its aspects, when it demands the abrogation of laws and the abolition of the mechanism that serves to impose them, when it refuses all hierarchical organization and preaches free agreement — at the same time strives to maintain and enlarge the precious kernel of social customs without which no human or animal society can exist.&quot; [[Peter Kropotkin]]. [http://www.theanarchistlibrary.org/HTML/Petr_Kropotkin__Anarchism__its_philosophy_and_ideal.html Anarchism: its philosophy and ideal]&lt;/ref&gt;&lt;ref&gt;&quot;anarchists are opposed to irrational (e.g., illegitimate) authority, in other words, hierarchy — hierarchy being the institutionalisation of authority within a society.&quot; [http://www.theanarchistlibrary.org/HTML/The_Anarchist_FAQ_Editorial_Collective__An_Anarchist_FAQ__03_17_.html#toc2 &quot;B.1 Why are anarchists against authority and hierarchy?&quot; in [[An Anarchist FAQ]]]&lt;/ref&gt; [[voluntary association]]s.&lt;ref&gt;&quot;ANARCHISM, a social philosophy that rejects authoritarian government and maintains that voluntary institutions are best suited to express man’s natural social tendencies.&quot; George Woodcock. &quot;Anarchism&quot; at The Encyclopedia of Philosophy&lt;/ref&gt;&lt;ref&gt;&quot;In a society developed on these lines, the voluntary associations which already now begin to cover all the fields of human activity would take a still greater extension so as to substitute themselves for the state in all its functions.&quot; [http://www.theanarchistlibrary.org/HTML/Petr_Kropotkin___Anarchism__from_the_Encyclopaedia_Britannica.html [[Peter Kropotkin]]. “Anarchism” from the Encyclopædia Britannica]&lt;/ref&gt;";

        Gson gson = new Gson();

        //get a ParsedPage object
            SimpleParser sp = new SimpleParser(documentText2);
        try {
            sp.getSections();
        } catch (WikipediaParseException ex) {
            Logger.getLogger(Wikipedia_solr.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println(sp.getParagraphText());
        try {
            System.out.println(sp.getSections());
         /*
                 MediaWikiParserFactory pf = new MediaWikiParserFactory();
                 MediaWikiParser parser = pf.createParser();
                 ParsedPage pp = parser.parse(documentText);
                 for(Paragraph p : pp.getParagraphs()){
                     
                     System.out.println(p.getText());
                 }
                 
                 //get the sections
                 for(Section section : pp.getSections()) {
                         System.out.println("section : " + section.getTitle());
                         System.out.println(" nr of paragraphs      : " + section.nrOfParagraphs());
                         System.out.println(" nr of tables          : " + section.nrOfTables());
                         System.out.println(" nr of nested lists    : " + section.nrOfNestedLists());
                         System.out.println(" nr of definition lists: " + section.nrOfDefinitionLists());
                 }
                 */
        } catch (WikipediaParseException ex) {
            Logger.getLogger(Wikipedia_solr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
