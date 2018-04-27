package br.github.superteits.brasille.utils;

import org.bukkit.entity.Player;

public enum ExpTable {
	
	Level0(0, 15L),
	Level1(1, 34L),
	Level2(2, 57L),
	Level3(3, 92L),
	Level4(4, 135L),
	Level5(5, 372L),
	Level6(6, 560L),
	Level7(7, 840L),
	Level8(8, 1144L),
	Level9(9, 1242L),
	Level10(10, 1573L),
	Level11(11, 2144L),
	Level12(12, 2800L),
	Level13(13, 3640L),
	Level14(14, 4700L),
	Level15(15, 5893L),
	Level16(16, 7360L),
	Level17(17, 9144L),
	Level18(18, 11120L),
	Level19(19, 13477L),
	Level20(20, 16268L),
	Level21(21, 19320L),
	Level22(22, 22880L),
	Level23(23, 27008L),
	Level24(24, 31477L),
	Level25(25, 36600L),
	Level26(26, 42444L),
	Level27(27, 48720L),
	Level28(28, 55813L),
	Level29(29, 63800L),
	Level30(30, 86784L),
	Level31(31, 98208L),
	Level32(32, 110932L),
	Level33(33, 124432L),
	Level34(34, 139372L),
	Level35(35, 155865L),
	Level36(36, 173280L),
	Level37(37, 192400L),
	Level38(38, 213345L),
	Level39(39, 235372L),
	Level40(40, 259392L),
	Level41(41, 285532L),
	Level42(42, 312928L),
	Level43(43, 342624L),
	Level44(44, 374760L),
	Level45(45, 408336L),
	Level46(46, 445544L),
	Level47(47, 483532L),
	Level48(48, 524160L),
	Level49(49, 567772L);
	
	private int level;
	private long xpToNextLvl;
	
	ExpTable(int level, long xpToNextLvl) {
		this.level = level;
		this.xpToNextLvl = xpToNextLvl;
	}
	
	public long getXpToNextLvl() {
		return this.xpToNextLvl;
	}
	public int getLvl() {
		return this.level;
	}
	
	public static ExpTable matchLevel(Player player) {
		switch (player.getLevel()) {
		case 0: return Level0;
		case 1: return Level1;
		case 2: return Level2;
		case 3: return Level3;
		case 4: return Level4;
		case 5: return Level5;
		case 6: return Level6;
		case 7: return Level7;
		case 8: return Level8;
		case 9: return Level9;
		case 10: return Level10;
		case 11: return Level11;
		case 12: return Level12;
		case 13: return Level13;
		case 14: return Level14;
		case 15: return Level15;
		case 16: return Level16;
		case 17: return Level17;
		case 18: return Level18;
		case 19: return Level19;
		case 20: return Level20;
		case 21: return Level21;
		case 22: return Level22;
		case 23: return Level23;
		case 24: return Level24;
		case 25: return Level25;
		case 26: return Level26;
		case 27: return Level27;
		case 28: return Level28;
		case 29: return Level29;
		case 30: return Level30;
		case 31: return Level31;
		case 32: return Level32;
		case 33: return Level33;
		case 34: return Level34;
		case 35: return Level35;
		case 36: return Level36;
		case 37: return Level37;
		case 38: return Level38;
		case 39: return Level39;
		case 40: return Level40;
		case 41: return Level41;
		case 42: return Level42;
		case 43: return Level43;
		case 44: return Level44;
		case 45: return Level45;
		case 46: return Level46;
		case 47: return Level47;
		case 48: return Level48;
		case 49: return Level49;
		default: return Level0;
		}
	}
}
