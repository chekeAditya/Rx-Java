package com.example.rxjavaoperator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LiveSessionActivity extends AppCompatActivity {

    private TextView textView;
    private Disposable disposable;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    //onSubsribe -> compositeDisposable.add(d)

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        disposable.clear(); //it means you stop observer ( if we go to the onPause it will automatically stop listening
//        disposable.dispose(); //it means you can't observe
    }



/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_session);
    }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            textView = findViewById(R.id.tv_data);
            Task task = new Task(1, "Go to Gym", true);
            Observable<Task> integerObservable = Observable.
                    fromIterable(getTaskList())
                    .filter(new Predicate<Task>() {
                        @Override
                        public boolean test(Task task) throws Throwable {
                            SystemClock.sleep(1000);
                            return task.isCompleted();
                        }
                    }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

            Observer<Task> integerObserver = new Observer<Task>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    disposable = d;
                    Log.d("Lloyd", "onSubscribe");
                }

                @Override
                public void onNext(@NonNull Task task) {
                    Log.d("Lloyd", "onNext " + task.getId());
                    String data = textView.getText().toString() + task.getTaskName();
                    textView.setText(data + "\n");
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.d("Lloyd", "onError " + e.getMessage());
                }

                @Override
                public void onComplete() {
                    Log.d("Lloyd", "onComplete");
                    String data = textView.getText().toString() + "Completed";
                    textView.setText(data + "\n");
                }
            };

            integerObservable.subscribe(integerObserver);
        }

        private List<Task> getTaskList() {
            List<Task> taskList = new ArrayList<>();

            for (int i = 0; i < 20; i++) {
                if (i % 2 == 0) {
                    Task task = new Task(i, "Task - " + i, true);
                    taskList.add(task);
                } else {
                    Task task = new Task(i, "Task - " + i, false);
                    taskList.add(task);
                }
            }
            return taskList;
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            disposable.dispose();
        }
    }
*/

//    mapTaskObservable
    /*
      Observable<Task> mapTaskObservable = Observable.create(new ObservableOnSubscribe<Task>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Task> emitter) throws Throwable {
                Task task = new Task(1, "Don project", false);
                if (!emitter.isDisposed()) {
                    emitter.onNext(task);
                }
            }
        }).map(new Function<Task, Task>() {
            @Override
            public Task apply(Task task) throws Throwable {
                task.setEstimatedTime("16:00 pm");
                return task;
            }
        });

        Observer<Task> taskObserver = new Observer<Task>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Task task) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        mapTaskObservable.subscribe(taskObserver);
     */


//    flatMap
    /*
    MovieResponseDTO movieResponseDTO = new MovieResponseDTO(1, getMovieList()); // getting from API

        Observable<Movie> movieObservable = Observable.
                just(movieResponseDTO)
                .flatMap(new Function<MovieResponseDTO, Observable<Movie>>() {
                    @Override
                    public Observable<Movie> apply(MovieResponseDTO movieResponseDTO) throws Throwable {
                        List<Movie> movieList = movieResponseDTO.getMovieList();
                        return Observable.fromIterable(movieList).subscribeOn(Schedulers.io());
                    }
                }).filter(new Predicate<Movie>() {
                    @Override
                    public boolean test(Movie movie) throws Throwable {
                        return movie.getRating() > 7;
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

        Observer<Movie> movieObserver = new Observer<Movie>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Movie movie) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        movieObservable.subscribe(movieObserver);
     */


//    intervalObservable
    /*
    Observable<Task> intervalObservable = Observable.interval(3, TimeUnit.SECONDS)
                .flatMap(new Function<Long, ObservableSource<Task>>() {
                    @Override
                    public ObservableSource<Task> apply(Long aLong) throws Throwable {
                        return Observable.fromIterable(getTaskList());
                    }
                });

        Observer<Task> intervalObserver = new Observer<Task>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Task task) {
                Log.d("Lloyd", task.getId() + "");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        intervalObservable.subscribe(intervalObserver);
     */
}