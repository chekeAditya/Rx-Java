* Loading data chunk by chunk is called pagination
* it's a library which load the data chunk by chunk, here we can specify how much data we should get
* Pagination will be based on the page.
--> Their are three major component
  1. Page Size -> PageList (observe Livedata) -> PagerAdapter -> recyclerView
    
--> Architecture pattern
** Paging Dependencies:-
    def paging_version = "3.1.0-alpha03"
    implementation "androidx.paging:paging-runtime-ktx:$paging_version"
  
** CharacterPagingSource:- key if of type integer, ModelClass) 
  => load:- this function is responsible for apiCalling or load data.
  => pagingConfig :- 
  => maxSize = 70 // it depend if we don't want the item then it will drop it


is it mandatory we should write pagenumber ? what it pagenumber won't be thier?
Name of th operator is elvis operator

