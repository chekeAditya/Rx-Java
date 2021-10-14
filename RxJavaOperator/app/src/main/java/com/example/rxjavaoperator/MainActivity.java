package com.example.rxjavaoperator;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private final String TAG = "Aditya";

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

        /* Create
        Observable<Task> taskObservable = Observable.create(new ObservableOnSubscribe<Task>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Task> emitter) throws Throwable {
                Task task = new Task(1, "Just do it", 10.0);
                if (!emitter.isDisposed()){
                    emitter.onNext(task);
                }

                List<StudentDetails> taskList = getStudentDetails();
                for (StudentDetails task1 : taskList){

                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

        Observer<Task> taskObserver = new Observer<Task>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(@NonNull Task task) {
                Log.d(TAG, "onNext: " + task.getName());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        taskObservable.subscribe(taskObserver);
    }
         */

        //R -> result T-> On which we are applying
        Integer mapInt = 5;
        Observable<Integer> integerObservable = Observable
                .just(mapInt)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer input) throws Throwable {
                        return input * 5;
//                        return input.toString() + "Changed"; //you can also transform it into string
                    }
                });
        Observer<Integer> mapIntObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.d(TAG, "onNext: " + integer.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        integerObservable.subscribe(mapIntObserver);
    }
        /*
        Observable<StudentDetails> studentDetailsObservable = Observable.interval(3, TimeUnit.SECONDS) //giving the delay of
                .flatMap(new Function<Long, ObservableSource<StudentDetails>>() {
                    @Override
                    public ObservableSource<StudentDetails> apply(Long aLong) throws Throwable {
                        return Observable.fromIterable(getStudentDetails());
                    }
                });
        Observer<StudentDetails> studentDetailsObserver = new Observer<StudentDetails>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull StudentDetails studentDetails) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        studentDetailsObservable.subscribe(studentDetailsObserver);
    }
         */

    private List<StudentDetails> getStudentDetails () {
        List<StudentDetails> studentDetailsList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            StudentDetails studentDetails = new StudentDetails("1st", i, "Aditya");
            StudentDetails studentDetails1 = new StudentDetails("1st", i, "Karan");
            StudentDetails studentDetails2 = new StudentDetails("1st", i, "oM");
            StudentDetails studentDetails3 = new StudentDetails("1st", i, "ayu");
            StudentDetails studentDetails4 = new StudentDetails("1st", i, "isha");
            studentDetailsList.add(studentDetails);
            studentDetailsList.add(studentDetails1);
            studentDetailsList.add(studentDetails2);
            studentDetailsList.add(studentDetails3);
            studentDetailsList.add(studentDetails4);
        }
        return studentDetailsList;
    }
}

/*
item ------> item = map
item ------>

* Flatmap is veryfast but the order wasn't maintained
* Concat it will do synchonous so it's not that much fast but here it will maintained the order
 */