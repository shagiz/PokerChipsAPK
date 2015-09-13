package com.shagi.poker.pokerchipsas.playeradapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shagi.poker.pokerchipsas.R;

import java.util.List;

/**
 * Created by Shagi on 19.08.2015.
 */
public class PlayerAdapter extends BaseAdapter {

    private List<Player> players;
    private LayoutInflater layoutInflater;

    public PlayerAdapter(Context context, List<Player> players) {
        this.players = players;
        layoutInflater= LayoutInflater.from(context);
    }

    static class ViewHolder{
        public TextView nameTextView;
        public TextView balanceTextView;
        public TextView moveTextView;
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Object getItem(int position) {
        return players.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=layoutInflater.inflate(R.layout.player_item,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.playerNameTxt);
            viewHolder.balanceTextView = (TextView) convertView.findViewById(R.id.balance_txtv);
            viewHolder.moveTextView = (TextView) convertView.findViewById(R.id.move_txt);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        Player player=getPlayer(position);
        viewHolder.nameTextView.setText(player.getName());
        viewHolder.balanceTextView.setText(""+player.getBalance());
        viewHolder.moveTextView.setText(player.getMove()+" "+player.getBet());
        return null;
    }

    private Player getPlayer(int position){
        return (Player) getItem(position);
    }
}
