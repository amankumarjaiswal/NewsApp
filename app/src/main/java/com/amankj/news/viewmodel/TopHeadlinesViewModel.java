package com.amankj.news.viewmodel;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.amankj.news.UseCaseProvider;
import com.amankj.news.usecase.TopHeadlinesUseCase;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TopHeadlinesViewModel extends ViewModel {
    private static final String TAG = TopHeadlinesViewModel.class.getSimpleName();

    private MutableLiveData<Object> articleListObservable;
    private CompositeDisposable compositeDisposable;
    private TopHeadlinesUseCase topHeadlinesUseCase;

    public TopHeadlinesViewModel() {
        articleListObservable = new MutableLiveData<>();
        compositeDisposable = new CompositeDisposable();
    }

    public MutableLiveData<Object> getArticleListObservable() {
        return articleListObservable;
    }

    public void getTopHeadlines() {
        topHeadlinesUseCase = UseCaseProvider.getTopHeadlinesUseCase();

        Disposable disposable = topHeadlinesUseCase.getTopHeadlines()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribe(o -> {
                    Log.d(TAG, "accept Object");
                    articleListObservable.postValue(o);
                }, throwable -> {
                    Log.d(TAG, "accept Throwable");
                    //articleListObservable.postValue();
                });

        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
