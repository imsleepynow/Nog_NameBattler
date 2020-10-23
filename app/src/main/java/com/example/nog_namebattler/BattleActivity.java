package com.example.nog_namebattler;

import androidx.appcompat.app.AppCompatActivity;
import gamedata.Party;
import namebattler_jokyu.Player;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

public class BattleActivity extends AppCompatActivity {

	// 定数宣言
	{
		static final int TEAM_MAX = 2;
		static final int TEAM_MEMB = 3;

    	static final int ONE_PERIOD = 30;
	}
	// 変数宣言
	{
		static int users = TEAM_MEMB * TEAM_MAX;	// 参加人数
		int taskTime = 0;	// 時間
		int beforeTime = -1;	// 時間
		int turn = 0;

		List<Party> party = new ArrayList<>();
		List<Player> player = new ArrayList<>();
	}

	// セッター
	public void setParties(List<Party> party) {
		this.party = party;
	}

	// =================================

	// 初期化かな？
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
    }

    // ネームバトラー丸ごと移植していいんかな
    // たぶん更新処理がここなんだと思うけど
    @Override
    protected void onResume() {
        super.onResume();

        {
           	player.clear();

        	// 先頭の並び替え、バフの管理
        	for(int i = 0; i < TEAM_MAX; i++) {
        		for(int j = 0; j < party.get(i).getMembers().size(); j++) {
        			player.add(party.get(i).getMembers().get(j));
        			//player.get(j).buffCheck(turnCount);
        		}
        	}
        		// 攻撃順番をAGiで判断、ソートしたキーの順番を返す ==========================
       		now = PlayerSortByAGI(player);
        		boolean end = false;
        		if(ONE_PERIOD * player.size() > beforeTime) {
       			for(int i = 0; i < player.size(); i++){
       				if(taskTime >= ONE_PERIOD * i &&
       					beforeTime < ONE_PERIOD * i) {
        					Player nowP = player.get(now.get(i));
       					if(nowP.getHp() > 0) {
        						// 攻撃 ===========================================================
       						int enemTeam = (nowP.getTeam() + 1) % TEAM_MAX;	// 攻撃対象チームを設定
       						nowP.getAI().action(nowP, party.get(enemTeam), turnCount);		// プレイヤーのAIを呼び出して行動させる
        						// チームメンバーが生き残ってる？ =====================================================
       						if(party.get(enemTeam).getMembers().size() <= 0) {
        							System.out.println();
       							System.out.println("チーム" + (nowP.getTeam() + 1) + "の勝利！！");
        							end = true;
       							break;
       						}
       					}
       				}
       			}
       			if(end) {
       				moveBattleEnd();
       			}
        		beforeTime = taskTime;
       			taskTime++;
        	}
        }
    }

 // 攻撃順番をAGiで判断、ソートしたものを返す ================
 	List<Integer> PlayerSortByAGI(List<Player> player) {

 		List<Integer> ret = new ArrayList<>();	// 返り値用

 		for(int i = 0; i < player.size(); i++) {
 			ret.add(i);
 		}
 		for(int i = 0; i < player.size() - 1; i++) {
 			for(int j = player.size() - 1; j > i; j--) {
 					// AGIの値で比較
 					if(player.get(ret.get(i)).getAgi() > player.get(ret.get(j)).getAgi()) {
					// リストから除外して尻に追加 --------
					int x = ret.get(i);
					ret.remove(i);
					ret.add(x);
					// -----------------------------------
				}
			}
		}
 		return ret;
 	}

    // ターン加算

 	private void plusTurn() {
 		if(ONE_PERIOD * player.size() > taskTime) {
 			turn++;
 			taskTime = 0;
 			beforeTime = -1;
 		}
 		else {
 			taskTime = 9999;
 		}
 	}



    // シーン移動・作戦変更
    public void moveChangeAi()
    {
    	Intent intent = (new Intent(this, ChangeAiActivity.class));
    	startActivity(intent);
    }

    // シーン移動・戦闘終了
    public void moveBattleEnd()
    {
    	Intent intent = (new Intent(this, BattleEndActivity.class));
    	startActivity(intent);
    }

}