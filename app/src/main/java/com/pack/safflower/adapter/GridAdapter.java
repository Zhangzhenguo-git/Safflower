package com.pack.safflower.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.pack.safflower.R;
import com.pack.safflower.databinding.GridItemBinding;
import com.pack.safflower.model.home.GridData;
import com.pack.safflower.widget.glide.GlideRoundTransform;

import org.w3c.dom.Text;

import java.util.List;

/**
 * @author Zhangzhenguo
 * @create 2020/9/24
 * @Email 18311371235@163.com
 * @Describe
 */
public class GridAdapter extends BaseAdapter {
    private Activity context;
    private List<GridData> items;
    private GridView gridView;
    private GridHolder holder;
    private OnGridItemLinstener onGridItemListener;

    public GridAdapter(Activity context, List<GridData> items, GridView gridView) {
        this.context = context;
        this.items = items;
        this.gridView = gridView;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            holder = new GridHolder();
            view = LayoutInflater.from(context).inflate(R.layout.grid_item, viewGroup, false);
            holder.ivGrid = view.findViewById(R.id.ivGridImg);
            holder.nameGrid = view.findViewById(R.id.tvGridName);

            view.setTag(holder);
        } else {
            holder = (GridHolder) view.getTag();
        }
        Glide.with(context)
                .load(items.get(i).getIcon())
                .apply(new RequestOptions().transform(new RoundedCorners(50)))
                .into(holder.ivGrid);
        holder.nameGrid.setText(items.get(i).getIconName());
        return view;
    }

    class GridHolder {
        ImageView ivGrid;
        TextView nameGrid;
    }

    /**
     * Item点击事件
     */
    public interface OnGridItemLinstener{
        void onItemClick(int position);
    }
    public void setOnGridItemListener(OnGridItemLinstener onGridItemListener){
        this.onGridItemListener=onGridItemListener;
    }
}
