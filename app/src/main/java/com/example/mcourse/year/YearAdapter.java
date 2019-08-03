/**
 * switch order matters!
 *
 * click the course to make the course selected, select two courses to switch them
 *
 * 1. Switch INFS1602 in Term 1 and MATH1131 in Term 3
 * 2. INFS1602 is prequisites for many courses. Warning appears, click "YEP"
 * 3. Wait for the progression bar
 * 4. Roadmap Succesfully updated, but the roadmap is not ideal
 * 5. Switch INFS1602 and ACCT1501, unsuccessful, hint shows INFS1602 not offered in term2
 * 6. Switch INFS1602 and ECON1101,
 * 7. Wait for the progression bar, and roadmap successful updated
 */

package com.example.mcourse.year;


import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.Handler;

import android.app.AlertDialog;
import android.widget.Toast;

import com.example.mcourse.MainActivity;
import com.example.mcourse.R;

import java.util.LinkedList;

public class YearAdapter extends BaseAdapter  {
    private LinkedList<Year> mData;
    private Context mContext;


    private boolean t1_c1_selected = false;
    private boolean t1_c3_selected = false;
    private boolean t2_c1_selected = false;
    private boolean t3_c2_selected = false;






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
        return getCount() == 0 ? null : mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview_item, null);

        final Handler handler = new Handler();

        final ProgressBar pb = (ProgressBar) view.findViewById(R.id.pb);

        final Button t2_c3 = (Button) view.findViewById(R.id.t2_c3);
        final Button t2_c2 = (Button) view.findViewById(R.id.t2_c2);
        final Button t2_c1 = (Button) view.findViewById(R.id.t2_c1);

        final Button t3_c3 = (Button) view.findViewById(R.id.t3_c3);
        final Button t3_c2 = (Button) view.findViewById(R.id.t3_c2);
        final Button t3_c1 = (Button) view.findViewById(R.id.t3_c1);

        final Button t1_c3 = (Button) view.findViewById(R.id.t1_c3);
        final Button t1_c2 = (Button) view.findViewById(R.id.t1_c2);
        final Button t1_c1 = (Button) view.findViewById(R.id.t1_c1);

        final Button t1 = (Button) view.findViewById(R.id.t1);
        final Button t2 = (Button) view.findViewById(R.id.t2);
        final Button t3 = (Button) view.findViewById(R.id.t3);
        t1.setText(mData.get(i).getTerm_1());
        t2.setText(mData.get(i).getTerm_2());
        t3.setText(mData.get(i).getTerm_3());


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

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t3_c3.getVisibility() == View.VISIBLE) {
                    t3.setText("T3");
                    t3.setBackgroundResource(R.drawable.bg_btn_term_selector);
                    t3_c3.setVisibility(View.GONE);
                    t3_c2.setVisibility(View.GONE);
                    t3_c1.setVisibility(View.GONE);
                } else if (t3_c3.getVisibility() == View.GONE) {
                    t3.setText("");
                    t3.setBackgroundResource(R.drawable.edit);
                    t3_c3.setVisibility(View.VISIBLE);
                    t3_c2.setVisibility(View.VISIBLE);
                    t3_c1.setVisibility(View.VISIBLE);
                }
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t1_c3.getVisibility() == View.VISIBLE) {
                    t1.setText("T1");
                    t1.setBackgroundResource(R.drawable.bg_btn_term_selector);
                    t1_c3.setVisibility(View.GONE);
                    t1_c2.setVisibility(View.GONE);
                    t1_c1.setVisibility(View.GONE);
                } else if (t1_c3.getVisibility() == View.GONE) {
                    t1.setText("");
                    t1.setBackgroundResource(R.drawable.edit);
                    t1_c3.setVisibility(View.VISIBLE);
                    t1_c2.setVisibility(View.VISIBLE);
                    t1_c1.setVisibility(View.VISIBLE);
                }
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t2_c3.getVisibility() == View.VISIBLE) {
                    t2.setText("T2");
                    t2.setBackgroundResource(R.drawable.bg_btn_term_selector);
                    t2_c3.setVisibility(View.GONE);
                    t2_c2.setVisibility(View.GONE);
                    t2_c1.setVisibility(View.GONE);
                } else if (t2_c3.getVisibility() == View.GONE) {
                    t2.setText("");
                    t2.setBackgroundResource(R.drawable.edit);
                    t2_c3.setVisibility(View.VISIBLE);
                    t2_c2.setVisibility(View.VISIBLE);
                    t2_c1.setVisibility(View.VISIBLE);
                }
            }
        });

        t1_c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                t1_c1_selected = true;
                t1_c1.setBackgroundResource(R.drawable.bg_btn_course_selected);
                if (t1_c1_selected && t3_c2_selected) {
                    final AlertDialog.Builder normalDialog =
                            new AlertDialog.Builder(view.getContext());
                    normalDialog.setTitle("Warning");
                    normalDialog.setMessage("INFS1602 is a prerequisite course for many courses, and moving it to later will affect many courses. Do you want to continue?");
                    normalDialog.setPositiveButton("Yep",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    pb.setVisibility(View.VISIBLE);
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                pb.setVisibility(View.GONE); // 隐藏
                                                t1_c1_selected = false;
                                                t3_c2_selected = false;
                                                t1_c1.setBackgroundResource(R.drawable.bg_btn_course_selector);
                                                t3_c2.setBackgroundResource(R.drawable.bg_btn_course_selector);
                                                t1_c1.setText("MATH1131");
                                                t1_c2.setText("MGMT1001");
                                                t1_c3.setText("ECON1101");
                                                t2_c1.setText("ACCT1501");
                                                t2_c2.setText("INFS1603");
                                                t2_c3.setText("MATH1041");
                                                t3_c1.setText("GENC2411");
                                                t3_c2.setText("INFS1602");
                                                t3_c3.setText("COMP1511");
                                                Toast toast = Toast.makeText(view.getContext(), "Roadmap has been successfully updated!" , Toast.LENGTH_LONG);
                                                toast.show();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }, 2000);
                                }
                            });
                    normalDialog.setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast toast = Toast.makeText(view.getContext(), "No changes are completed" , Toast.LENGTH_LONG);
                                    toast.show();
                                }
                            });
                    // 显示
                    normalDialog.show();



                }
            }
        });

        t1_c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                t1_c2.setBackgroundResource(R.drawable.bg_btn_course_selected);
            }
        });
        t1_c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                t1_c3_selected = true;
                t1_c3.setBackgroundResource(R.drawable.bg_btn_course_selected);
                if(t1_c3_selected & t3_c2_selected) {
                    pb.setVisibility(View.VISIBLE);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                pb.setVisibility(View.GONE); // 隐藏
                                t1_c3_selected = false;
                                t3_c2_selected = false;
                                t1_c3.setBackgroundResource(R.drawable.bg_btn_course_selector);
                                t3_c2.setBackgroundResource(R.drawable.bg_btn_course_selector);
                                t1_c1.setText("COMP1511");
                                t1_c2.setText("MGMT1001");
                                t1_c3.setText("INFS1602");
                                t2_c1.setText("MATH1041");
                                t2_c2.setText("INFS1603");
                                t2_c3.setText("INFS1609");
                                t3_c1.setText("INFS2621");
                                t3_c2.setText("ECON1101");
                                t3_c3.setText("MATH1131");
                                Toast toast = Toast.makeText(view.getContext(), "Roadmap has been successfully updated!" , Toast.LENGTH_LONG);
                                toast.show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, 2000);
                }
            }
        });
        t2_c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                t2_c1_selected = true;
                t2_c1.setBackgroundResource(R.drawable.bg_btn_course_selected);
                if (t2_c1_selected && t3_c2_selected) {
                    pb.setVisibility(View.VISIBLE);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                pb.setVisibility(View.GONE); // 隐藏
                                t2_c1_selected = false;
                                t3_c2_selected = false;
                                t2_c1.setBackgroundResource(R.drawable.bg_btn_course_selector);
                                t3_c2.setBackgroundResource(R.drawable.bg_btn_course_selector);
                                Toast toast = Toast.makeText(view.getContext(), "Failed to move...\nINFS1602 is not offered in term 2" , Toast.LENGTH_LONG);
                                toast.show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, 1000);

                }

            }
        });
        t2_c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2_c2.setBackgroundResource(R.drawable.bg_btn_course_selected);
            }
        });
        t2_c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2_c3.setBackgroundResource(R.drawable.bg_btn_course_selected);

            }
        });
        t3_c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                t3_c2.setBackgroundResource(R.drawable.bg_btn_course_selected);

            }
        });
        t3_c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                t3_c2_selected = true;
                t3_c2.setBackgroundResource(R.drawable.bg_btn_course_selected);
                if (t2_c1_selected && t3_c2_selected) {
                    pb.setVisibility(View.VISIBLE);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                pb.setVisibility(View.GONE); // 隐藏
                                t2_c1_selected = false;
                                t3_c2_selected = false;
                                t2_c1.setBackgroundResource(R.drawable.bg_btn_course_selector);
                                t3_c2.setBackgroundResource(R.drawable.bg_btn_course_selector);
                                Toast toast = Toast.makeText(view.getContext(), "Failed to move...\nINFS1602 is not offered in term 2" , Toast.LENGTH_LONG);
                                toast.show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, 1000);

                }
                if(t1_c3_selected & t3_c2_selected) {
                    pb.setVisibility(View.VISIBLE);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                pb.setVisibility(View.GONE); // 隐藏
                                t1_c3_selected = false;
                                t3_c2_selected = false;
                                t1_c3.setBackgroundResource(R.drawable.bg_btn_course_selector);
                                t3_c2.setBackgroundResource(R.drawable.bg_btn_course_selector);
                                t1_c1.setText("COMP1511");
                                t1_c2.setText("MGMT1001");
                                t1_c3.setText("INFS1602");
                                t2_c1.setText("MATH1041");
                                t2_c2.setText("INFS1603");
                                t2_c3.setText("INFS1609");
                                t3_c1.setText("INFS2621");
                                t3_c2.setText("ECON1101");
                                t3_c3.setText("MATH1131");
                                Toast toast = Toast.makeText(view.getContext(), "Roadmap has been successfully updated!" , Toast.LENGTH_LONG);
                                toast.show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, 2000);
                }
                if (t1_c1_selected && t3_c2_selected) {
                    final AlertDialog.Builder normalDialog =
                            new AlertDialog.Builder(view.getContext());
                    normalDialog.setTitle("Warning");
                    normalDialog.setMessage("INFS1602 is a prerequisite course for many courses, and moving it to later will affect many courses. Do you want to continue?");
                    normalDialog.setPositiveButton("Yep",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    pb.setVisibility(View.VISIBLE);
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                pb.setVisibility(View.GONE); // 隐藏
                                                t1_c1_selected = false;
                                                t3_c2_selected = false;
                                                t1_c1.setBackgroundResource(R.drawable.bg_btn_course_selector);
                                                t3_c2.setBackgroundResource(R.drawable.bg_btn_course_selector);
                                                t1_c1.setText("MATH1131");
                                                t1_c2.setText("MGMT1001");
                                                t1_c3.setText("ECON1101");
                                                t2_c1.setText("ACCT1501");
                                                t2_c2.setText("INFS1603");
                                                t2_c3.setText("MATH1041");
                                                t3_c1.setText("GENC2411");
                                                t3_c2.setText("INFS1602");
                                                t3_c3.setText("COMP1511");
                                                Toast toast = Toast.makeText(view.getContext(), "Roadmap has been successfully updated!" , Toast.LENGTH_LONG);
                                                toast.show();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }, 2000);
                                }
                            });
                    normalDialog.setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast toast = Toast.makeText(view.getContext(), "No changes are completed" , Toast.LENGTH_LONG);
                                    toast.show();
                                }
                            });
                    // 显示
                    normalDialog.show();



                }
            }
        });
        t3_c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t3_c3.setBackgroundResource(R.drawable.bg_btn_course_selected);
            }
        });

        return view;
    }



}