package com.sbbs.me.android.adapter;

import java.util.List;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rarnu.devlib.base.adapter.BaseAdapter;
import com.sbbs.me.android.R;
import com.sbbs.me.android.api.SbbsMeArticle;

public class SbbsMeArticleAdapter extends BaseAdapter<SbbsMeArticle> {

	public SbbsMeArticleAdapter(Context context, List<SbbsMeArticle> list) {
		super(context, list);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			v = inflater.inflate(R.layout.item_article, parent, false);
		}
		SbbsMeArticleHolder holder = (SbbsMeArticleHolder) v.getTag();
		if (holder == null) {
			holder = new SbbsMeArticleHolder();
			holder.tvSubject = (TextView) v.findViewById(R.id.tvSubject);
			holder.tvBody = (TextView) v.findViewById(R.id.tvBody);
			v.setTag(holder);
		}
		SbbsMeArticle item = list.get(position);
		if (item != null) {
			holder.tvSubject.setText(item.Subject);
			holder.tvBody.setText(Html.fromHtml(item.Body));
		}
		return v;
	}

	@Override
	public String getValueText(SbbsMeArticle item) {
		// TODO Auto-generated method stub
		return null;
	}

}
