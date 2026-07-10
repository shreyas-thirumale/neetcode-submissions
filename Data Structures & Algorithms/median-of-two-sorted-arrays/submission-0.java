class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int targIn = (nums1.length + nums2.length) / 2;
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            int f = nums1[p1];
            int s = nums2[p2];
            if (f < s) {
                arr[i] = f;
                p1++;
            } else {
                arr[i] = s;
                p2++;
            }
            if (i == targIn) {
                if (arr.length % 2 == 0) {
                    return ((double) arr[i] + (double) arr[i-1]) / 2;
                } else {
                    return (double) arr[i];
                }
            }
            i++;
        }
        while (p1 < nums1.length) {
            arr[i] = nums1[p1];
            p1++;
            if (i == targIn) {
                if (arr.length % 2 == 0) {
                    return ((double) arr[i] + (double) arr[i-1]) / 2;
                } else {
                    return (double) arr[i];
                }
            }
            i++;
        }
        while (p2 < nums2.length) {
            arr[i] = nums2[p2];
            p2++;
            if (i == targIn) {
                if (arr.length % 2 == 0) {
                    return ((double) arr[i] + (double) arr[i-1]) / 2;
                } else {
                    return (double) arr[i];
                }
            }
            i++;
        }
        return -1;
    }
}
