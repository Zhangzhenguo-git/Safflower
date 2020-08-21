package com.pack.jetpack.paging;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.pack.jetpack.R;
import com.pack.jetpack.databinding.ActivityPagingBinding;
import com.pack.jetpack.room.database.WorksEntity;
import com.pack.jetpack.room.database.WorksRepository;


public class PagingActivity extends AppCompatActivity {

    private ActivityPagingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_paging);

        final PagingAdapter adapter=new PagingAdapter();
        binding.pagingRecycleView.setAdapter(adapter);
        binding.pagingRecycleView.setLayoutManager(new LinearLayoutManager(this));
        LiveData<PagedList<WorksEntity>> datas = new LivePagedListBuilder<>(WorksRepository.getInstance(this).getWorksDao().getWorksForPaging(),15).build();
        datas.observe(this, new Observer<PagedList<WorksEntity>>() {
            @Override
            public void onChanged(PagedList<WorksEntity> worksEntities) {
                adapter.submitList(worksEntities);
            }
        });
    }
}