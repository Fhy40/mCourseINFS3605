package com.example.mcourse.year;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mcourse.R;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class YearAdapter extends BaseAdapter {
    private LinkedList<Year> mData;
    private Context mContext;

    static private Button t3;
    private TextView txtDaily, txtDailyShow, txtWeekly, txtWeeklyShow, txtMonthly, txtMonthlyShow;
    private boolean isFold = true; // 卫星按钮展开状态

    private Animation dailyUnfoldAnimation, dailyFoldAnimation, weeklyUnfoldAnimation,
            weeklyFoldAnimation, monthlyUnfoldAnimation, monthlyFoldAnimation;


    private View view;


    public YearAdapter(LinkedList<Year> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(mContext).inflate(R.layout.listview_item, viewGroup, false);

        this.view = view;

        final Button t1 = (Button) view.findViewById(R.id.t1);
        final Button t2 = (Button) view.findViewById(R.id.t2);
        final Button t3 = (Button) view.findViewById(R.id.t3);
        t1.setText(mData.get(i).getTerm_1());
        t2.setText(mData.get(i).getTerm_2());
        t3.setText(mData.get(i).getTerm_3());

        initUI(); // 初始化界面
        initAnimation(); // 初始化动画

        if (i == 0) {
            view.setBackgroundResource(R.drawable.year_5);
        } else if (i == 1) {
            view.setBackgroundResource(R.drawable.year_4);
        } else if (i == 2) {
            view.setBackgroundResource(R.drawable.year_3);
        } else if (i == 3) {
            view.setBackgroundResource(R.drawable.year_2);
        } else if (i == 4) {
            view.setBackgroundResource(R.drawable.year_1);
        }
        return view;
    }

    private void initUI() {
        t3 = (Button) view.findViewById(R.id.t3);
        txtDaily = (TextView) view.findViewById(R.id.daily_dialy_textview);
        txtDailyShow = (TextView) view.findViewById(R.id.daily_dialy_show_textview);
        txtWeekly = (TextView) view.findViewById(R.id.daily_weekly_textview);
        txtWeeklyShow = (TextView) view.findViewById(R.id.daily_weekly_show_textview);
        txtMonthly = (TextView) view.findViewById(R.id.daily_monthly_textview);
        txtMonthlyShow = (TextView) view.findViewById(R.id.daily_monthly_show_textview);

        // 绑定事件
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFold) {
                    txtDaily.startAnimation(dailyUnfoldAnimation);
                    txtWeekly.startAnimation(weeklyUnfoldAnimation);
                    txtMonthly.startAnimation(monthlyUnfoldAnimation);
                } else {
                    txtDaily.startAnimation(dailyFoldAnimation);
                    txtWeekly.startAnimation(weeklyFoldAnimation);
                    txtMonthly.startAnimation(monthlyFoldAnimation);
                }
                isFold = !isFold;
                if (isFold) {
                    t3.setBackgroundResource(R.drawable.write_daily_fold_icon);
                } else {
                    t3.setBackgroundResource(R.drawable.write_daily_unfold_icon);
                }
            }
        });
    }



    private void initAnimation() {
        // 展开日报，展开结束时，在停留点显示控件
        dailyUnfoldAnimation = new TranslateAnimation( Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -2f);
        dailyUnfoldAnimation.setDuration(1500);
        dailyUnfoldAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                System.out.println(txtDailyShow.getVisibility() + " ye " + t3.getVisibility());
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                txtDailyShow.setVisibility(View.VISIBLE);
                t3.setVisibility(View.INVISIBLE);
                System.out.println(txtDailyShow.getVisibility() + " wow " + t3.getVisibility());
            }
        });
        // 收起日报，开始动画时，隐藏起始点控件
        dailyFoldAnimation = new TranslateAnimation( Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -2f, Animation.RELATIVE_TO_SELF, 0f);
        dailyFoldAnimation.setDuration(1500);
        dailyFoldAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                txtDailyShow.setVisibility(View.GONE);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
            }
        });
        // 展开周报
        weeklyUnfoldAnimation = new TranslateAnimation( Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -2f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
        weeklyUnfoldAnimation.setDuration(1500);
        weeklyUnfoldAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                txtWeeklyShow.setVisibility(View.VISIBLE);
            }
        });
        // 收起周报
        weeklyFoldAnimation = new TranslateAnimation( Animation.RELATIVE_TO_SELF, -2f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
        weeklyFoldAnimation.setDuration(1500);
        weeklyFoldAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                txtWeeklyShow.setVisibility(View.GONE);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
            }
        });
        // 展开月报
        monthlyUnfoldAnimation = new TranslateAnimation( Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2f);
        monthlyUnfoldAnimation.setDuration(1500);
        monthlyUnfoldAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                txtMonthlyShow.setVisibility(View.VISIBLE);
            }
        });
        // 收起月报
        monthlyFoldAnimation = new TranslateAnimation( Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 2f, Animation.RELATIVE_TO_SELF, 0f);
        monthlyFoldAnimation.setDuration(11500);
        monthlyFoldAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                txtMonthlyShow.setVisibility(View.GONE);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
            }
        });
    }





}
