package com.example.rxjavaoperator;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Problems_On_RxJava_Day1 extends AppCompatActivity {

    Button mBtnJustButton, mBtnFromArrayButton, mBtnRangeButton, mBtnStudentSorting;
    private final String TAG = "Aditya";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problems_on_rx_java_day1);

        mBtnFromArrayButton = findViewById(R.id.btnFromArray);
        mBtnJustButton = findViewById(R.id.btnJustButton);
        mBtnRangeButton = findViewById(R.id.btnRangeButton);
        mBtnStudentSorting = findViewById(R.id.btnStudentSorting);

        justButtonClicked();
        fromArrayButtonClicked();
        rangeButtonClicked();
        sortStudentByNameLength();
    }

    private void sortStudentByNameLength() {
        mBtnStudentSorting.setOnClickListener(view -> {
            Observable<StudentDetails> studentDetailsObservable = Observable.fromIterable(getStudentDetails()).filter(new Predicate<StudentDetails>() {
                @Override
                public boolean test(StudentDetails studentDetails) throws Throwable {
                    return studentDetails.getStudentName().length() > 6;
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            Observer<StudentDetails> studentDetailsObserver = new Observer<StudentDetails>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    Log.d(TAG, "onSubscribe");
                }

                @Override
                public void onNext(@NonNull StudentDetails studentDetails) {
                    Log.d(TAG, "Student List :- " + studentDetails.getStudentName());
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.d(TAG, "onError");
                }

                @Override
                public void onComplete() {
                    Log.d(TAG, "onComplete");
                }
            };
            studentDetailsObservable.subscribe(studentDetailsObserver);
        });
    }

    private void rangeButtonClicked() {
        mBtnRangeButton.setOnClickListener(view -> {
            Observable<Integer> integerObservable = Observable.range(20, 20);
            Observer<Integer> integerObserver = new Observer<Integer>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    Log.d(TAG, "onSubscribe");
                }

                @Override
                public void onNext(@NonNull Integer integer) {
                    Log.d(TAG, integer.toString());
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.d(TAG, "onError");
                }

                @Override
                public void onComplete() {
                    Log.d(TAG, "onComplete");
                }
            };
            integerObservable.subscribe(integerObserver);
        });
    }

    private void fromArrayButtonClicked() {
        mBtnFromArrayButton.setOnClickListener(view -> {
            String[] name = {"Aditya", "Sudarshan", "Karan", "Prachi"};
            Observable<String> stringObservable = Observable.fromArray(name);
            Observer<String> stringObserver = new Observer<String>() {

                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    Log.d(TAG, "onSubscribe");
                }

                @Override
                public void onNext(@NonNull String s) {
                    Log.d(TAG, s);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.d(TAG, "onError");
                }

                @Override
                public void onComplete() {
                    Log.d(TAG, "onComplete");
                }
            };
            stringObservable.subscribe(stringObserver);
        });
    }

    private void justButtonClicked() {
        mBtnJustButton.setOnClickListener(view -> {
            String name = "Aditya";
            Observable<String> stringObservable = Observable.just(name);
            Observer<String> stringObserver = new Observer<String>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    Log.d(TAG, "onSubscribe");
                }

                @Override
                public void onNext(@NonNull String s) {
                    Log.d(TAG, "onNext Name is : - " + s);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.d(TAG, "onError");
                }

                @Override
                public void onComplete() {
                    Log.d(TAG, "onComplete: Task Completed");
                }
            };
            stringObservable.subscribe(stringObserver);
        });
    }

    private List<StudentDetails> getStudentDetails() {
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
