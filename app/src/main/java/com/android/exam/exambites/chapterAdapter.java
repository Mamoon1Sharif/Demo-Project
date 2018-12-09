package com.android.exam.exambites;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class chapterAdapter extends ArrayAdapter {
    List imagelist;
    List textlist;
    public chapterAdapter(@NonNull Context context, int resource, List<ArrayList> imagelist,List<ArrayList> textlist) {
        super(context, resource);
        this.imagelist=imagelist;
        this.textlist=textlist;
    }

    @Override
    public int getCount() {
        return imagelist.size();
    }
    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }
    @Nullable
    @Override
    public Object getItem(int position) {
        return textlist.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.chap, null);
        }

        ViewHolder holder = new ViewHolder();
        Object p=getItem(position);
        if (p != null) {

            holder.textView = (TextView) v.findViewById(R.id.listchaptext);
            holder.imageView = (ImageView) v.findViewById(R.id.listchapimage);


            holder.textView.setText(textlist.get(position).toString());
            holder.imageView.setImageResource((Integer) imagelist.get(position));




//            new ImageLoadTask(imagelist, position).execute(holder);

        }
        v.setTag(holder);
        return v;
    }



//    private static class ImageLoadTask extends AsyncTask<ViewHolder, Void, Bitmap> {
//        private final List mFakeImageLoader;
//        private final int position;
//
//        private ViewHolder v;
//
//        private ImageLoadTask(List mFakeImageLoader, int position) {
//            this.mFakeImageLoader = mFakeImageLoader;
//            this.position = position;
//        }
//
//        @Override
//        protected Bitmap doInBackground(ViewHolder... params) {
//            v = params[0];
//            return (Bitmap) mFakeImageLoader.get(position);
//        }
//
//        @Override
//        protected void onPostExecute(Bitmap result) {
//            super.onPostExecute(result);
//
//                // If this item hasn't been recycled already, hide the
//                // progress and set and show the image
//
//                v.imageView.setImageBitmap(result);
//
//        }
//    }




}
