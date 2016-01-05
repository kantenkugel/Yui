package net.dv8tion.discord.commands;

import java.util.Arrays;
import java.util.List;

import net.dv8tion.discord.util.Downloader;
import net.dv8tion.discord.util.GoogleSearch;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import org.apache.commons.lang3.StringUtils;

public class MyAnimeListCommand extends Command
{
    public static final String ANIME_URL = "http://myanimelist.net/anime/";
    public static final String MANGA_URL = "http://myanimelist.net/manga/";
    public static final String CHARACTER_URL = "http://myanimelist.net/character/";

    @Override
    public void onCommand(MessageReceivedEvent e, String[] args)
    {
        GoogleSearch search = new GoogleSearch(
                String.format("%s+%s",
                        StringUtils.join(args, "+", 1, args.length),
                        "site:myanimelist.net"));

        sendMessage(e, search.getSuggestedReturn());
    }

    @Override
    public List<String> getAliases()
    {
        return Arrays.asList(".mal");
    }

    @Override
    public String getDescription()
    {
        return "Searches the <http://myanimelist.net> anime/manga database for anime and manga.";
    }

    @Override
    public String getName()
    {
        return "MyAnimeList Search";
    }

    @Override
    public String getUsageInstructions()
    {
        return ".mal *<search terms>*\n"
                + "__Example:__ .mal sao\n"
                + " - This will return the entry for Sword Art Online.\n"
                + "__Example 2:__ .mal magi kingdom of magic\n"
                + " - This will return the entry for Magi - The Kingdom of Magic.";
    }

    @SuppressWarnings("unused")
    private String handleSearch(GoogleSearch search)
    {
        String url = search.getUrl(0);
        if (url.contains(ANIME_URL))
        {
            System.out.println("this is anime");
            String webpage = Downloader.webpage("http://myanimelist.net/manga/75989/");
            System.out.println(webpage);
        }
        else if (url.contains(MANGA_URL))
        {
            System.out.println("this is manga");
            String webpage = Downloader.webpage(url);
            System.out.println(webpage);
        }
        else if (url.contains(CHARACTER_URL))
        {
            System.out.println("this is character");
        }
        else
        {
        }
        return null;
    }
}
