package com.example.nog_namebattler;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//プレイヤーのクラス
public class Player{

	// フィールド変数 ======================================
	protected String name = "";
	protected String job = "なし";
	protected int hp = 0;		// 体力
	protected int mp = 0;		// 魔力
	protected int str = 0;	// 攻撃力
	protected int def = 0;	// 防御力
	protected int luck = 0;	// 運の良さ
	protected int agi = 0;		// 素早さ
	protected int team = 0;	// 所属陣営

	//protected List<Buff> buff = new ArrayList<Buff>();

	//protected int strBuff = 0;	// 攻撃力バフ
	//protected int defBuff = 0;	// 防御力バフ
	//protected int luckBuff = 0;	// 運の良さバフ
	//protected int agiBuff = 0;		// 素早さバフ

	//protected AIManager  ai;			// さくせん

	// コンストラクタ ======================================
	Player(String name){
		this.name = name;

		ai = new AIManager(new AIRandom());

		makeCharacter();
	}

	// キャラクター作成 ======================================
	void makeCharacter(){

		// 名前からデータに変換
		hp = getNumber(name, 0);
		mp = getNumber(name, 1);
		str = getNumber(name, 2);
		def = getNumber(name, 3);
		luck = getNumber(name, 4);
		agi = getNumber(name, 5);
	}

	// ゲッター  ======================================

	String getName() {
		return name;
	}

	int getHp() {
		return hp;
	}

	int getMp() {
		return mp;
	}

	int getStr() {
		return str + strBuff;
	}

	int getDef() {
		return def + defBuff;
	}

	int getLuck() {
		return luck + luckBuff;
	}

	int getAgi() {
		return agi + agiBuff;
	}

	int getTeam() {
		return team;
	}

	void setTeam(int t) {
		team = t;
	}

	AIManager getAI() {
		return ai;
	}

	List<Buff> getBuff(){
		return buff;
	}

	//void setBuff(Buff buff){
	//	this.buff.add(buff);
	//}

	// ステータスを表示 ======================================
	void printStates() {
		System.out.println("名前 : " + name);
		System.out.println("職業 : " + job);
		System.out.println("  HP : " + hp);
		System.out.println("  MP : " + mp);
		System.out.println(" STR : " + str);
		System.out.println(" DEF : " + def);
		System.out.println("LUCK : " + luck);
		System.out.println(" AGI : " + agi);
		System.out.println("");
	}

	// 名前のハッシュから数値に変換  ======================================
	protected Integer getNumber(String name, Integer index) {

		try {
			byte[] result = MessageDigest.getInstance("SHA-1").digest(name.getBytes());
			String digest = String.format("%040x", new BigInteger(1, result));
			String hex = digest.substring(index * 2, index * 2 + 2);
			return Integer.parseInt(hex, 16);
		}
		catch (Exception e){
			e.printStackTrace();
		}

		return 0;

	}

	// 攻撃 ======================================
	void attack(Player enemy, int nowTurn) {



	}

	// 通常攻撃 ======================================
	protected void normalAttack(Player enemy){

		System.out.println(getName() + "の攻撃！");

		enemy.damage(calcDamage(enemy));

		if(enemy.getHp() <= 0) {
			System.out.println(enemy.getName() + "は力尽きた…");
		}
	}

	// 今出せる 一番強い攻撃 ===========================
	protected void mostStrongAttack(Player enemy, int nowTurn) {
	}

	// 与ダメ計算 ======================================
	protected int calcDamage(Player enemy){

		int damage = 0;

		// 自攻撃力と敵防御力を設定
		Random rand = new Random();

		int attack = getStr();
		int defence = enemy.getDef();


		// 会心の一撃
		if(rand.nextInt(512) < getLuck()){
			defence = 0;
			System.out.print("会心の一撃！！");
		}

		damage = attack - defence;

		// ダメージ値が0以下
		if(damage <= 0) {
			damage = 0;
		}

		return damage;
	}

	// ダメージを受ける ======================================
	void damage(int damage) {
		System.out.println(getName() + "に" + damage + "のダメージ！");
		hp -= damage;
	}

	/*
	// バフの管理 ==============================================

	void buffCheck(int nowTurn) {
		int sb = 0;
		int db = 0;
		int lb = 0;
		int ab = 0;
		for(int i = 0; i < buff.size(); i++) {
			if(buff.get(i).isEndTurn(nowTurn)) {
				buff.remove(i);
			}
			else {
				sb += buff.get(i).getStr();
				db += buff.get(i).getDef();
				lb += buff.get(i).getLuck();
				ab += buff.get(i).getAgi();
			}
		}
		strBuff = sb;
		defBuff = db;
		luckBuff = lb;
		agiBuff = ab;
	}
	 */

	// ======================================
}