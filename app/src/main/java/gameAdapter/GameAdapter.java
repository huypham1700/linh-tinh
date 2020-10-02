package gameAdapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practiceapp.R;

import java.util.ArrayList;

import model.Game;
import view.GameView;

public class GameAdapter extends RecyclerView.Adapter<GameView> {
    private ArrayList<Game> games;
    private Context context;
    public GameAdapter(Context context, ArrayList<Game> games) {
        this.context = context;
        this.games=games;
    }

    @NonNull
    @Override
    public GameView onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
       View gameView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_view,viewGroup,false);
        return new GameView(gameView);
    }

    @Override
    public void onBindViewHolder(@NonNull GameView holder, int position) {
        holder.setGame(this.games.get(position));
    }

    @Override
    public int getItemCount() {
        return this.games.size();
    }
}
