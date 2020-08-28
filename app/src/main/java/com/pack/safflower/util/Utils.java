package com.pack.safflower.util;

import com.pack.safflower.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * auth aboom
 * date 2019-12-26
 */
public class Utils {
    //本地资源
    public static final int[] IMAGES = {
            R.mipmap.banner_icon1,
            R.mipmap.banner_icon2,
            R.mipmap.banner_icon3,
            R.mipmap.banner_icon4,
            R.mipmap.banner_icon5,
            R.mipmap.banner_icon6,
    };

    public static List<Integer> getImage(int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(IMAGES[i]);
        }
        return list;
    }

    public static int getRandomImage() {
        return IMAGES[new Random().nextInt(IMAGES.length)];
    }


    /**
     * 在线资源-----------------------------------------------------------------------
     */

    private static final String[] URLS = {
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2860421298,3956393162&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=163638141,898531478&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1028426622,4209712325&fm=26&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1462142898,440466184&fm=26&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3210855908,3095539181&fm=26&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2080505558,2205047574&fm=26&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2894881224,342594760&fm=26&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2894881224,342594760&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3162346827,2000964752&fm=26&gp=0.jpg"
    };

    public static String getRandom() {
        return URLS[new Random().nextInt(URLS.length)];
    }

    public static List<String> getData(int size) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(getRandom());
        }
        return list;
    }


}
