package me.joe.cesium.config;

import net.minecraft.util.Formatting;

import java.util.List;
import java.util.Map;

public class cfg {
    //config
    public  String Prefix = ".";
    public  int DecimalColorMain = 2006271;
    public  int DecimalColorCommands = 2667775;
    public  int DecimalColorCommandArgLight = 3983615;
    public  int DecimalColorCommandArgDark = 21621;
    public  int DecimalColorCommandError = 16737894;
    public  Formatting FormattingColorMain = Formatting.BLUE;
    public  Formatting FormattingColorSecondary = Formatting.DARK_BLUE;
    public  Formatting FormattingColorMainErr = Formatting.RED;
    public  Formatting FormattingColorSecondaryErr = Formatting.DARK_RED;
    public  Formatting FormattingColorMainWrn = Formatting.YELLOW;
    public  Formatting FormattingColorSecondaryWrn = Formatting.GOLD;
    public  String ErrKey = "ERROR";
    public  String WrnKey = "WARNING";
    //for things like CUtils.info
    public  String ClientName = "joemod";
    public  String CommandSplitterRegex = "(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)\\s+";

    public  final String[] CommandStyleOptions = new String[]{
            "NORMAL",
            "GRADIENT",
            "RAINBOW",
            "TYPEBASED"
    };
    public  int DefaultArgumentColor = 16702823;
    public  int DefaultArgumentColorAlternate = 13081600;
    public  List<Map<String,Integer>> TypeColors = List.of(
            Map.of("PlayerListEntryArgumentType",64511),
            Map.of("StringArrayArgumentType",7733118),
            Map.of("AngleArgumentType",0),
            Map.of("BlockMirrorArgumentType",0),
            Map.of("BlockPosArgumentType",0),
            Map.of("BlockPredicateArgumentType",0),
            Map.of("BlockRotationArgumentType",0),
            Map.of("BlockStateArgumentType",0),
            Map.of("BoolArgumentType",16741120),
            Map.of("ColorArgumentType",0),
            Map.of("ColumnPosArgumentType",0),
            Map.of("CommandFunctionArgumentType",0),
            Map.of("DimensionArgumentType",0),
            Map.of("DoubleArgumentType",16768256),
            Map.of("EntityAnchorArgumentType",0),
            Map.of("EntityArgumentType",64511),
            Map.of("EnumArgumentType",16711914),
            Map.of("FloatArgumentType",16768256),
            Map.of("NumberRangeArgumentType.FloatRangeArgumentType",16768256),
            Map.of("GameModeArgumentType",0),
            Map.of("GameProfileArgumentType",0),
            Map.of("HeightmapArgumentType",0),
            Map.of("IdentifierArgumentType",0),
            Map.of("IntegerArgumentType",16768256),
            Map.of("NumberRangeArgumentType.IntRangeArgumentType",16768256),
            Map.of("ItemPredicateArgumentType",34047),
            Map.of("ItemSlotArgumentType",34047),
            Map.of("ItemStackArgumentType",34047),
            Map.of("LongArgumentType",16768256),
            Map.of("MessageArgumentType",0),
            Map.of("NbtCompoundArgumentType",0),
            Map.of("NbtElementArgumentType",0),
            Map.of("NbtPathArgumentType", 0),
            Map.of("OperationArgumentType",0),
            Map.of("ParticleEffectArgumentType",0),
            Map.of("RegistryEntryArgumentType",0),
            Map.of("RegistryEntryPredicateArgumentType",0),
            Map.of("RegistryKeyArgumentType",0),
            Map.of("RotationArgumentType",0),
            Map.of("ScoreboardObjectiveArgumentType",0),
            Map.of("ScoreboardCriterionArgumentType",0),
            Map.of("ScoreboardSlotArgumentType",0),
            Map.of("ScoreHolderArgumentType",0),
            Map.of("StringArgumentType",60176),
            Map.of("SwizzleArgumentType",0),
            Map.of("TeamArgumentType",0),
            Map.of("TestClassArgumentType",0),
            Map.of("TestFunctionArgumentType",0),
            Map.of("TextArgumentType",0),
            Map.of("TimeArgumentType",0),
            Map.of("UuidArgumentType",10879231),
            Map.of("Vec2ArgumentType",10879231),
            Map.of("Vec3ArgumentType",10879231)
    );

    public  String SelectedCommandStyle = "TYPEBASED";//CommandStyleOptions[1];
    public  int StyleRainbowGradientLength = 10;//CommandStyleOptions[1];
}
