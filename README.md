**DiffUtils to update RecyclerView adapter:**
 1. create a generic DiffUtils.kt class
 2. Extend DiffUtil.Callback() and applied overrides. 
 3. After that, define two lists in the constructor as old and new list. 
    This class checks if list items are the same.
 4. Created a basic data class as Item.kt that takes an id and a name parameters.
 5. Create RecyclerviewAdapter and call the setItems function and give an item list
 6. CustomDiffUtils checks the differences between the list in the adapter and the list we provide and updates it to the current version.
 7. If your list is too large, check out [AsyncListDiffer](https://developer.android.com/reference/androidx/recyclerview/widget/AsyncListDiffer) to avoid using it in the main thread.
