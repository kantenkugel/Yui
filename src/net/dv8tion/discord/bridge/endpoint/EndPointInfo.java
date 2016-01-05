package net.dv8tion.discord.bridge.endpoint;

import net.dv8tion.jda.entities.TextChannel;
import org.pircbotx.Channel;

public class EndPointInfo
{
    public static final String SEPARATOR = ":";
    private EndPointType type;
    private String connectorId;
    private String channelId;

    public EndPointInfo(EndPointType type, String connectorId, String channelId)
    {
        this.connectorId = connectorId;
        this.channelId = channelId;
        this.type = type;
    }

    public String getConnectorId()
    {
        return connectorId;
    }

    public void setConnectorId(String connectorId)
    {
        this.connectorId = connectorId;
    }

    public String getChannelId()
    {
        return channelId;
    }

    public void setChannelId(String channelId)
    {
        this.channelId = channelId;
    }

    public String toString()
    {
        return type.getName() + SEPARATOR + connectorId + SEPARATOR + channelId;
    }

    public EndPointType getType()
    {
        return type;
    }

    public void setType(EndPointType type)
    {
        this.type = type;
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof EndPointInfo))
            return false;
        EndPointInfo oInfo = (EndPointInfo) o;
        return toString().equals(oInfo.toString());
    }

    public static EndPointInfo createFromDiscordChannel(TextChannel channel)
    {
        return new EndPointInfo(EndPointType.DISCORD, channel.getGuild().getId(), channel.getId());
    }

    public static EndPointInfo createFromIrcChannel(String identifier, Channel channel)
    {
        return new EndPointInfo(EndPointType.IRC, identifier, channel.getName());
    }
}
