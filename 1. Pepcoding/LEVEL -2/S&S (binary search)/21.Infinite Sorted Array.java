//Only code
public static int binarySearch(int []arr,int low,int high,int target)
{
    if(low>high)
    return -1;
    int mid=low+(high-low)/2;
    if(arr[mid]==target) return mid;
    if(target<arr[mid]) return binarySearch(arr,low,mid-1,target);
    return binarySearch(arr,mid+1,high,target);
}
public static int binarySearchInfinite(int []arr,int low,int high,int target)
{
    if(low>high) return -1;
    if(target>=arr[low]&&target<=arr[high])
    {
        return binarySearch(arr,low,high,target);
    }else
    {
        return binarySearchInfinite(arr,high+1,2*high,target);
    }
}