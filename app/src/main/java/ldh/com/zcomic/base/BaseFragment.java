package ldh.com.zcomic.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by allen liu on 2018/5/2.
 */

public abstract class BaseFragment extends Fragment {
//    protected Context mContext ;
    protected View mView ;
    protected Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int resRootViewId =  getResRootViewId () ;
        mView = inflater.inflate(resRootViewId , container , false) ;
//      mContext = this.getContext() ;
//        initData(getArguments());
        ButterKnife.bind(this,mView); // 不能漏写，不然后面会报空指针异常
        initData();
        initListener();
        return mView ;
    }
//    protected abstract void initData(Bundle arguments);
    protected abstract void initData();
    protected abstract int getResRootViewId() ;
    protected abstract void initListener();
}
