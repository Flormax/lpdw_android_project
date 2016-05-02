package lol.meteoapp;

import java.util.Hashtable;

/**
 * Created by root on 21/04/16.
 */
public final class WeatherRessources {
    public static final int BIG_WEATHER_SUN = R.drawable.big_sun;
    public static final int BIG_WEATHER_RAIN = R.drawable.big_rain;
    public static final int BIG_WEATHER_SHOWER_RAIN = R.drawable.big_shower_rain;
    public static final int BIG_WEATHER_SNOW = R.drawable.big_snow;
    public static final int BIG_WEATHER_MIST = R.drawable.big_mist;
    public static final int BIG_WEATHER_FEW_CLOUDS = R.drawable.big_few_clouds;
    public static final int BIG_WEATHER_CLOUDS = R.drawable.big_clouds;
    public static final int BIG_WEATHER_STORM = R.drawable.big_storm;
    public static final int BIG_WEATHER_WARNING = R.drawable.big_warning;

    public static final int SMALL_WEATHER_SUN = R.drawable.small_sun;
    public static final int SMALL_WEATHER_RAIN = R.drawable.small_rain;
    public static final int SMALL_WEATHER_SHOWER_RAIN = R.drawable.small_shower_rain;
    public static final int SMALL_WEATHER_SNOW = R.drawable.small_snow;
    public static final int SMALL_WEATHER_MIST = R.drawable.small_mist;
    public static final int SMALL_WEATHER_FEW_CLOUDS = R.drawable.small_few_clouds;
    public static final int SMALL_WEATHER_CLOUDS = R.drawable.small_clouds;
    public static final int SMALL_WEATHER_STORM = R.drawable.small_storm;
    public static final int SMALL_WEATHER_WARNING = R.drawable.small_warning;

    public static final Hashtable<Integer, Integer> BIG_ICONS = new Hashtable<>();
    public static final Hashtable<Integer, Integer> SMALL_ICONS = new Hashtable<>();
    public static final Hashtable<Integer, Integer> DESCRIPTIONS = new Hashtable<>();

    public static void setBigIconsHashMap(){
        BIG_ICONS.put(200, BIG_WEATHER_STORM);
        BIG_ICONS.put(201, BIG_WEATHER_STORM);
        BIG_ICONS.put(202, BIG_WEATHER_STORM);
        BIG_ICONS.put(210, BIG_WEATHER_STORM);
        BIG_ICONS.put(211, BIG_WEATHER_STORM);
        BIG_ICONS.put(212, BIG_WEATHER_STORM);
        BIG_ICONS.put(221, BIG_WEATHER_STORM);
        BIG_ICONS.put(230, BIG_WEATHER_STORM);
        BIG_ICONS.put(231, BIG_WEATHER_STORM);
        BIG_ICONS.put(232, BIG_WEATHER_STORM);

        BIG_ICONS.put(300, BIG_WEATHER_SHOWER_RAIN);
        BIG_ICONS.put(301, BIG_WEATHER_SHOWER_RAIN);
        BIG_ICONS.put(302, BIG_WEATHER_SHOWER_RAIN);
        BIG_ICONS.put(310, BIG_WEATHER_SHOWER_RAIN);
        BIG_ICONS.put(311, BIG_WEATHER_SHOWER_RAIN);
        BIG_ICONS.put(312, BIG_WEATHER_SHOWER_RAIN);
        BIG_ICONS.put(313, BIG_WEATHER_SHOWER_RAIN);
        BIG_ICONS.put(314, BIG_WEATHER_SHOWER_RAIN);
        BIG_ICONS.put(321, BIG_WEATHER_SHOWER_RAIN);
        BIG_ICONS.put(520, BIG_WEATHER_SHOWER_RAIN);
        BIG_ICONS.put(521, BIG_WEATHER_SHOWER_RAIN);
        BIG_ICONS.put(522, BIG_WEATHER_SHOWER_RAIN);
        BIG_ICONS.put(531, BIG_WEATHER_SHOWER_RAIN);

        BIG_ICONS.put(500, BIG_WEATHER_RAIN);
        BIG_ICONS.put(501, BIG_WEATHER_RAIN);
        BIG_ICONS.put(502, BIG_WEATHER_RAIN);
        BIG_ICONS.put(503, BIG_WEATHER_RAIN);
        BIG_ICONS.put(504, BIG_WEATHER_RAIN);

        BIG_ICONS.put(511, BIG_WEATHER_SNOW);
        BIG_ICONS.put(600, BIG_WEATHER_SNOW);
        BIG_ICONS.put(601, BIG_WEATHER_SNOW);
        BIG_ICONS.put(611, BIG_WEATHER_SNOW);
        BIG_ICONS.put(612, BIG_WEATHER_SNOW);
        BIG_ICONS.put(615, BIG_WEATHER_SNOW);
        BIG_ICONS.put(616, BIG_WEATHER_SNOW);
        BIG_ICONS.put(620, BIG_WEATHER_SNOW);

        BIG_ICONS.put(701, BIG_WEATHER_MIST);
        BIG_ICONS.put(711, BIG_WEATHER_MIST);
        BIG_ICONS.put(721, BIG_WEATHER_MIST);
        BIG_ICONS.put(731, BIG_WEATHER_MIST);
        BIG_ICONS.put(741, BIG_WEATHER_MIST);
        BIG_ICONS.put(751, BIG_WEATHER_MIST);
        BIG_ICONS.put(761, BIG_WEATHER_MIST);
        BIG_ICONS.put(762, BIG_WEATHER_MIST);
        BIG_ICONS.put(771, BIG_WEATHER_MIST);
        BIG_ICONS.put(781, BIG_WEATHER_MIST);

        BIG_ICONS.put(800, BIG_WEATHER_SUN);

        BIG_ICONS.put(801, BIG_WEATHER_FEW_CLOUDS);
        BIG_ICONS.put(802, BIG_WEATHER_FEW_CLOUDS);
        BIG_ICONS.put(803, BIG_WEATHER_CLOUDS);
        BIG_ICONS.put(804, BIG_WEATHER_CLOUDS);

        BIG_ICONS.put(900, BIG_WEATHER_WARNING);
        BIG_ICONS.put(901, BIG_WEATHER_WARNING);
        BIG_ICONS.put(902, BIG_WEATHER_WARNING);
        BIG_ICONS.put(903, BIG_WEATHER_WARNING);
        BIG_ICONS.put(904, BIG_WEATHER_WARNING);
        BIG_ICONS.put(905, BIG_WEATHER_WARNING);
        BIG_ICONS.put(906, BIG_WEATHER_WARNING);
        BIG_ICONS.put(951, BIG_WEATHER_WARNING);
        BIG_ICONS.put(952, BIG_WEATHER_WARNING);
        BIG_ICONS.put(953, BIG_WEATHER_WARNING);
        BIG_ICONS.put(954, BIG_WEATHER_WARNING);
        BIG_ICONS.put(955, BIG_WEATHER_WARNING);
        BIG_ICONS.put(956, BIG_WEATHER_WARNING);
        BIG_ICONS.put(957, BIG_WEATHER_WARNING);
        BIG_ICONS.put(958, BIG_WEATHER_WARNING);
        BIG_ICONS.put(959, BIG_WEATHER_WARNING);
        BIG_ICONS.put(960, BIG_WEATHER_WARNING);
        BIG_ICONS.put(961, BIG_WEATHER_WARNING);
        BIG_ICONS.put(962, BIG_WEATHER_WARNING);
    }

    public static void setSmallIconsHashMap(){
        SMALL_ICONS.put(200, SMALL_WEATHER_STORM);
        SMALL_ICONS.put(201, SMALL_WEATHER_STORM);
        SMALL_ICONS.put(202, SMALL_WEATHER_STORM);
        SMALL_ICONS.put(210, SMALL_WEATHER_STORM);
        SMALL_ICONS.put(211, SMALL_WEATHER_STORM);
        SMALL_ICONS.put(212, SMALL_WEATHER_STORM);
        SMALL_ICONS.put(221, SMALL_WEATHER_STORM);
        SMALL_ICONS.put(230, SMALL_WEATHER_STORM);
        SMALL_ICONS.put(231, SMALL_WEATHER_STORM);
        SMALL_ICONS.put(232, SMALL_WEATHER_STORM);

        SMALL_ICONS.put(300, SMALL_WEATHER_SHOWER_RAIN);
        SMALL_ICONS.put(301, SMALL_WEATHER_SHOWER_RAIN);
        SMALL_ICONS.put(302, SMALL_WEATHER_SHOWER_RAIN);
        SMALL_ICONS.put(310, SMALL_WEATHER_SHOWER_RAIN);
        SMALL_ICONS.put(311, SMALL_WEATHER_SHOWER_RAIN);
        SMALL_ICONS.put(312, SMALL_WEATHER_SHOWER_RAIN);
        SMALL_ICONS.put(313, SMALL_WEATHER_SHOWER_RAIN);
        SMALL_ICONS.put(314, SMALL_WEATHER_SHOWER_RAIN);
        SMALL_ICONS.put(321, SMALL_WEATHER_SHOWER_RAIN);
        SMALL_ICONS.put(520, SMALL_WEATHER_SHOWER_RAIN);
        SMALL_ICONS.put(521, SMALL_WEATHER_SHOWER_RAIN);
        SMALL_ICONS.put(522, SMALL_WEATHER_SHOWER_RAIN);
        SMALL_ICONS.put(531, SMALL_WEATHER_SHOWER_RAIN);

        SMALL_ICONS.put(500, SMALL_WEATHER_RAIN);
        SMALL_ICONS.put(501, SMALL_WEATHER_RAIN);
        SMALL_ICONS.put(502, SMALL_WEATHER_RAIN);
        SMALL_ICONS.put(503, SMALL_WEATHER_RAIN);
        SMALL_ICONS.put(504, SMALL_WEATHER_RAIN);

        SMALL_ICONS.put(511, SMALL_WEATHER_SNOW);
        SMALL_ICONS.put(600, SMALL_WEATHER_SNOW);
        SMALL_ICONS.put(601, SMALL_WEATHER_SNOW);
        SMALL_ICONS.put(611, SMALL_WEATHER_SNOW);
        SMALL_ICONS.put(612, SMALL_WEATHER_SNOW);
        SMALL_ICONS.put(615, SMALL_WEATHER_SNOW);
        SMALL_ICONS.put(616, SMALL_WEATHER_SNOW);
        SMALL_ICONS.put(620, SMALL_WEATHER_SNOW);

        SMALL_ICONS.put(701, SMALL_WEATHER_MIST);
        SMALL_ICONS.put(711, SMALL_WEATHER_MIST);
        SMALL_ICONS.put(721, SMALL_WEATHER_MIST);
        SMALL_ICONS.put(731, SMALL_WEATHER_MIST);
        SMALL_ICONS.put(741, SMALL_WEATHER_MIST);
        SMALL_ICONS.put(751, SMALL_WEATHER_MIST);
        SMALL_ICONS.put(761, SMALL_WEATHER_MIST);
        SMALL_ICONS.put(762, SMALL_WEATHER_MIST);
        SMALL_ICONS.put(771, SMALL_WEATHER_MIST);
        SMALL_ICONS.put(781, SMALL_WEATHER_MIST);

        SMALL_ICONS.put(800, SMALL_WEATHER_SUN);

        SMALL_ICONS.put(801, SMALL_WEATHER_FEW_CLOUDS);
        SMALL_ICONS.put(802, SMALL_WEATHER_FEW_CLOUDS);
        SMALL_ICONS.put(803, SMALL_WEATHER_CLOUDS);
        SMALL_ICONS.put(804, SMALL_WEATHER_CLOUDS);

        SMALL_ICONS.put(900, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(901, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(902, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(903, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(904, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(905, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(906, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(951, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(952, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(953, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(954, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(955, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(956, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(957, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(958, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(959, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(960, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(961, SMALL_WEATHER_WARNING);
        SMALL_ICONS.put(962, SMALL_WEATHER_WARNING);
    }

    public static void setDescriptionsHashMap(){
        DESCRIPTIONS.put(200, R.string.code200);
        DESCRIPTIONS.put(201, R.string.code201);
        DESCRIPTIONS.put(202, R.string.code202);
        DESCRIPTIONS.put(210, R.string.code210);
        DESCRIPTIONS.put(211, R.string.code211);
        DESCRIPTIONS.put(212, R.string.code212);
        DESCRIPTIONS.put(221, R.string.code221);
        DESCRIPTIONS.put(230, R.string.code230);
        DESCRIPTIONS.put(231, R.string.code231);
        DESCRIPTIONS.put(232, R.string.code232);

        DESCRIPTIONS.put(300, R.string.code300);
        DESCRIPTIONS.put(301, R.string.code301);
        DESCRIPTIONS.put(302, R.string.code302);
        DESCRIPTIONS.put(310, R.string.code310);
        DESCRIPTIONS.put(311, R.string.code311);
        DESCRIPTIONS.put(312, R.string.code312);
        DESCRIPTIONS.put(313, R.string.code313);
        DESCRIPTIONS.put(314, R.string.code314);
        DESCRIPTIONS.put(321, R.string.code321);
        DESCRIPTIONS.put(520, R.string.code520);
        DESCRIPTIONS.put(521, R.string.code521);
        DESCRIPTIONS.put(522, R.string.code522);
        DESCRIPTIONS.put(531, R.string.code531);

        DESCRIPTIONS.put(500, R.string.code500);
        DESCRIPTIONS.put(501, R.string.code501);
        DESCRIPTIONS.put(502, R.string.code502);
        DESCRIPTIONS.put(503, R.string.code503);
        DESCRIPTIONS.put(504, R.string.code504);

        DESCRIPTIONS.put(511, R.string.code511);
        DESCRIPTIONS.put(600, R.string.code600);
        DESCRIPTIONS.put(601, R.string.code601);
        DESCRIPTIONS.put(611, R.string.code611);
        DESCRIPTIONS.put(612, R.string.code612);
        DESCRIPTIONS.put(615, R.string.code615);
        DESCRIPTIONS.put(616, R.string.code616);
        DESCRIPTIONS.put(620, R.string.code620);

        DESCRIPTIONS.put(701, R.string.code701);
        DESCRIPTIONS.put(711, R.string.code711);
        DESCRIPTIONS.put(721, R.string.code721);
        DESCRIPTIONS.put(731, R.string.code731);
        DESCRIPTIONS.put(741, R.string.code741);
        DESCRIPTIONS.put(751, R.string.code751);
        DESCRIPTIONS.put(761, R.string.code761);
        DESCRIPTIONS.put(762, R.string.code762);
        DESCRIPTIONS.put(771, R.string.code771);
        DESCRIPTIONS.put(781, R.string.code781);

        DESCRIPTIONS.put(800, R.string.code800);

        DESCRIPTIONS.put(801, R.string.code801);
        DESCRIPTIONS.put(802, R.string.code802);
        DESCRIPTIONS.put(803, R.string.code803);
        DESCRIPTIONS.put(804, R.string.code804);

        DESCRIPTIONS.put(900, R.string.code900);
        DESCRIPTIONS.put(901, R.string.code901);
        DESCRIPTIONS.put(902, R.string.code902);
        DESCRIPTIONS.put(903, R.string.code903);
        DESCRIPTIONS.put(904, R.string.code904);
        DESCRIPTIONS.put(905, R.string.code905);
        DESCRIPTIONS.put(906, R.string.code906);
        DESCRIPTIONS.put(951, R.string.code951);
        DESCRIPTIONS.put(952, R.string.code952);
        DESCRIPTIONS.put(953, R.string.code953);
        DESCRIPTIONS.put(954, R.string.code954);
        DESCRIPTIONS.put(955, R.string.code955);
        DESCRIPTIONS.put(956, R.string.code956);
        DESCRIPTIONS.put(957, R.string.code957);
        DESCRIPTIONS.put(958, R.string.code958);
        DESCRIPTIONS.put(959, R.string.code959);
        DESCRIPTIONS.put(960, R.string.code960);
        DESCRIPTIONS.put(961, R.string.code961);
        DESCRIPTIONS.put(962, R.string.code962);
    }
}
