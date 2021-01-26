package cdio4.cots.foodoffer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.model.Photo;

public class PhotoAdapter  extends PagerAdapter {
    private Context mContext;
    private List<Photo> mListPhoto;

    public PhotoAdapter(Context mContext, List<Photo> mListPhoto) {
        this.mContext = mContext;
        this.mListPhoto = mListPhoto;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo,container,false);
        ImageView imgPhoto = view.findViewById(R.id.img_photo);
        Photo photo = mListPhoto.get(position);
        if(photo!=null){
            Glide.with(mContext)
                    .load(photo.getResURL())
                    .into(imgPhoto);
            imgPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"Day la image "+position,Toast.LENGTH_LONG).show();
                }
            });
        }
        //Add view to viewgroup
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if(mListPhoto!=null){
            return mListPhoto.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //Remove view
        container.removeView((View) object) ;
    }
}
