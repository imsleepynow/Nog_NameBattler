package com.example.nog_namebattler;

import java.util.ArrayList;

public class Party {

	// 変数宣言 =================================================
	private ArrayList<Player> members;

	private int team = 0;

	// コンストラクタ ===========================================
	Party(int team) {
		members = new ArrayList<Player>();
		this.team = team;
	}

	// ゲッター、セッター =======================================

	ArrayList<Player> getMembers() {
		return members;
	}

	// 処理 =====================================================
	public void appendPlayer(Player player) {
		player.setTeam(team);
		members.add(player);
	}

	public void RemovePlayer(Player player) {
		members.remove(player);
	}

}
