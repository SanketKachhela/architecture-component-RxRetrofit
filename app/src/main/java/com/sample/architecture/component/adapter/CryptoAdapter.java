package com.sample.architecture.component.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.sample.architecture.component.R;
import com.sample.architecture.component.databinding.RecyclerItemBinding;
import com.sample.architecture.component.model.CoinPriceModel;

import java.util.ArrayList;

/**
 * Created by Madhav Gor on 09-07-2017.
 */

public class CryptoAdapter extends RecyclerView.Adapter<CryptoAdapter.RepositoryViewHolder> {

    private final ArrayList<CoinPriceModel> cryptoPriceList;

    public CryptoAdapter(ArrayList<CoinPriceModel> cryptoPriceList){
        this.cryptoPriceList = cryptoPriceList;
    }

    @Override
    public CryptoAdapter.RepositoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final RecyclerItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.recycler_item,viewGroup, false);
        return new RepositoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CryptoAdapter.RepositoryViewHolder repositoryViewHolder, int position) {
        repositoryViewHolder.binding.setRepository(getItem(position));
    }

    private CoinPriceModel getItem(int position){
        return cryptoPriceList.get(position);
    }

    @Override
    public int getItemCount() {
        return cryptoPriceList.size();
    }

    public class RepositoryViewHolder extends RecyclerView.ViewHolder {

        final RecyclerItemBinding binding;

        public RepositoryViewHolder(RecyclerItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
