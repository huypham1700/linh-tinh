package view;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practiceapp.R;

import model.Game;

public class GameView extends RecyclerView.ViewHolder {
    private  ImageView imageView;
    private TextView productName;
    private  TextView productDescription;
    private RatingBar ratingBar;

    private Game game;
    public GameView(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.PRODUCT_IMAGE);
        productName = itemView.findViewById(R.id.PRODUCT_NAME);
        productDescription = itemView.findViewById(R.id.PRODUCT_DESCRIPTION);
        ratingBar = itemView.findViewById(R.id.PRODUCT_RATING_BAR);
    }
    public void setGame(Game game){
        this.game = game;
        imageView.setImageURI(Uri.parse(game.getImageURL()));
        productName.setText(game.getName());
        productDescription.setText((game.getDescription()));
        ratingBar.setRating(game.getRating());

    }
}
