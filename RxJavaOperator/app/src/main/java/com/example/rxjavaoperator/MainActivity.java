package com.example.rxjavaoperator;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
         * it will create the data
         * just is the operator which will be called depend on the size of the Observable
         */
//        textView = findViewById(R.id.tvData);

        /*
        //For Integer Response
        Integer integer = 1;
        Observable<Integer> integerObservable = Observable.just(integer);
        //it will be consumer of data
        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("Aditya", "onSubscribe");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.d("Aditya", "onNext");
                String data = textView.getText().toString() + integer; //getting the data
                textView.setText(data +"\n");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("Aditya", "onError");
            }

            @Override
            public void onComplete() {
                Log.d("Aditya", "onComplete");
            }
        };

         //make a connection between observable and observer or (subscribe observable to get the adta)
        integerObservable.subscribe(integerObserver);
         */

        /*
        //API Response
        Task task = new Task(1,"Android Rx Java",100.1);
        Observable<Task> taskObservable = Observable.just(task);
        Observer<Task> taskObserver = new Observer<Task>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("Aditya", "onSubscribe");
            }

            @Override
            public void onNext(@NonNull Task task) {
                Log.d("Aditya", "onNext");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("Aditya", "onError");
            }

            @Override
            public void onComplete() {
                Log.d("Aditya", "onComplete");
            }
        };
       taskObservable.subscribe(taskObserver);
         */


/*
        //For ArrayList of Response
        Observable<Task> taskObservable = Observable.fromIterable(getTaskList()).filter(new Predicate<Task>() {
            @Override
            public boolean test(Task task) throws Throwable {
                SystemClock.sleep(1000);
                return task.getPrice().equals(100.0);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers
                        .mainThread()); //when we said subscribeOn

        //it will be consumer of data
        Observer<Task> taskObserver = new Observer<Task>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("Aditya", "onSubscribe");
            }

            @Override
            public void onNext(@NonNull Task task) {
                Log.d("Aditya", "onNext" + task.getId());
                String data = textView.getText().toString() + task.getName(); //getting the data
                textView.setText(data + "\n");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("Aditya", "onError");
            }

            @Override
            public void onComplete() {
                Log.d("Aditya", "onComplete");
            }
        };

        //make a connection between observable and observer or (subscribe observable to get the adta)
        taskObservable.subscribe(taskObserver);
    }

    private List<Task> getTaskList() {
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                Task task = new Task(i, "Task - " + i, 100.0);
                taskList.add(task);
            } else {
                Task task = new Task(i, "Task - " + i, 200.0);
                taskList.add(task);
            }
        }
        return taskList;
    }
         */

/*
        //For Repeat time
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        Observable<Integer> repeatTime = Observable.range(2, 5)
//                .fromArray(arr)
//                .repeat()
//                .timeInterval()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        //it will be consumer of data
        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("Aditya", "onSubscribe");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.d("Aditya", "onNext");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("Aditya", "onError");
            }

            @Override
            public void onComplete() {
                Log.d("Aditya", "onComplete");
            }
        };

        //make a connection between observable and observer or (subscribe observable to get the adta)
        repeatTime.subscribe(integerObserver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

 */
    }
}