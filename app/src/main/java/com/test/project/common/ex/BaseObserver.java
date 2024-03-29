package com.test.project.common.ex;

import android.support.annotation.NonNull;
import android.util.Log;

import com.test.project.domain.BaseResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import mvp.ljb.kt.contract.IViewContract;

public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {

    private IViewContract mView;

    @Override
    public final void onSubscribe(@NonNull Disposable d) {

        Log.i("Net","--onSubscribe---" + d);
        onSubscribeEx(d);
    }

    public BaseObserver(IViewContract viewContract) {
        mView = viewContract;
    }

    @Override
    public final void onNext(@NonNull BaseResponse<T> data) {
        mView.dismissLoading();
        Log.i("Net","--onNext---" + data.toString());
        T t = data.getData();
        if (t == null){
            onNextSN();
            return;
        }
        onNextEx(t);
    }

    @Override
    public final void onError(@NonNull Throwable e) {
        mView.dismissLoading();
        Log.i("Net","--onError---" + e.toString());
        onErrorEx(e);
    }

    @Override
    public final void onComplete() {
        mView.dismissLoading();
        Log.i("Net","--onComplete---");
        onCompleteEx();
    }

    //Java实现下划线开头的方法
    protected void onCompleteEx() {

    }

    protected void onSubscribeEx(@NonNull Disposable d) {

    }

    protected void onNextEx(@NonNull T data) {

    }

    protected void onErrorEx(@NonNull Throwable e) {

    }

    protected void onNextSN(){

    }

}
