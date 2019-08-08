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


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mcourse.R;
import com.example.mcourse.course_web_activity;

import java.util.LinkedList;

public class YearAdapter extends BaseAdapter  {
    private LinkedList<Year> mData;
    private Context mContext;


    private boolean t1_c1_selected = false;
    private boolean t1_c3_selected = false;
    private boolean t2_c1_selected = false;
    private boolean t3_c2_selected = false;

    private boolean switch_selected = false;
    private boolean view_selected = true;

    private String temp = null;
    private Button btn_temp = null;
    private int count = 0;





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

        final Button btn_switch = (Button) view.findViewById(R.id.btn_switch);
        final Button btn_view = (Button) view.findViewById(R.id.btn_view);

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


        btn_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch_selected = true;
                view_selected = false;
                btn_switch.setBackgroundResource(R.drawable.bg_btn_set_selected);
                btn_view.setBackgroundResource(R.drawable.bg_btn_set_selector);
            }
        });

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch_selected = false;
                view_selected = true;
                btn_view.setBackgroundResource(R.drawable.bg_btn_set_selected);
                btn_switch.setBackgroundResource(R.drawable.bg_btn_set_selector);
                t1_c1_selected = false;
                t1_c3_selected = false;
                t2_c1_selected = false;
                t1_c1_selected = false;
                t3_c2_selected = false;
                t1_c1.setBackgroundResource(R.drawable.bg_btn_course_selector);
                t1_c2.setBackgroundResource(R.drawable.bg_btn_course_selector);
                t1_c3.setBackgroundResource(R.drawable.bg_btn_course_selector);
                t2_c1.setBackgroundResource(R.drawable.bg_btn_course_selector);
                t2_c2.setBackgroundResource(R.drawable.bg_btn_course_selector);
                t2_c3.setBackgroundResource(R.drawable.bg_btn_course_selector);
                t3_c1.setBackgroundResource(R.drawable.bg_btn_course_selector);
                t3_c2.setBackgroundResource(R.drawable.bg_btn_course_selector);
                t3_c3.setBackgroundResource(R.drawable.bg_btn_course_selector);

                count = 0;
                temp = null;
                btn_temp = null;
            }
        });


        t1_c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(view_selected) {
                    identifyCourse((String)t1_c1.getText());
                }
                if(switch_selected) {
                    t1_c1_selected = true;
                    t1_c1.setBackgroundResource(R.drawable.bg_btn_course_selected);

                    if (t1_c1_selected && t3_c2_selected) {
                        final AlertDialog.Builder normalDialog =
                                new AlertDialog.Builder(view.getContext());
                        count = 0;
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
                                        t1_c1_selected = false;
                                        t3_c2_selected = false;
                                        t1_c1.setBackgroundResource(R.drawable.bg_btn_course_selector);
                                        t3_c2.setBackgroundResource(R.drawable.bg_btn_course_selector);

                                        toast.show();
                                    }
                                });
                        // 显示
                        normalDialog.show();



                    } else {
                        count++;
                        if (count == 1) {
                            temp = (String) t1_c1.getText();
                            btn_temp = t1_c1;
                        } else if (count == 2) {
                            btn_temp.setText(t1_c1.getText());
                            t1_c1.setText(temp);
                            t1_c1.setBackgroundResource(R.drawable.bg_btn_course_selector);
                            btn_temp.setBackgroundResource(R.drawable.bg_btn_course_selector);
                            count = 0;
                            btn_temp = null;
                            t1_c1_selected = false;
                            t1_c3_selected = false;
                            t2_c1_selected = false;
                            t3_c2_selected = false;
                            Toast toast = Toast.makeText(view.getContext(), "Roadmap has been successfully updated!" , Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                }

            }
        });

        t1_c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view_selected) {
                    identifyCourse((String)t1_c2.getText());
                }
                if(switch_selected) {
                    t1_c2.setBackgroundResource(R.drawable.bg_btn_course_selected);
                    count++;
                    if(count == 1) {
                        temp = (String)t1_c2.getText();
                        btn_temp = t1_c2;
                    } else if (count == 2) {
                        btn_temp.setText(t1_c2.getText());
                        t1_c2.setText(temp);
                        t1_c2.setBackgroundResource(R.drawable.bg_btn_course_selector);
                        btn_temp.setBackgroundResource(R.drawable.bg_btn_course_selector);
                        count = 0;
                        btn_temp = null;
                        t1_c1_selected = false;
                        t1_c3_selected = false;
                        t2_c1_selected = false;
                        t3_c2_selected = false;
                        Toast toast = Toast.makeText(view.getContext(), "Roadmap has been successfully updated!" , Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            }
        });
        t1_c3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {
                if(view_selected) {
                    identifyCourse((String)t1_c3.getText());
                }
                if(switch_selected) {
                    t1_c3_selected = true;
                    t1_c3.setBackgroundResource(R.drawable.bg_btn_course_selected);

                    if(t1_c3_selected & t3_c2_selected) {
                        pb.setVisibility(View.VISIBLE);
                        count = 0;
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
                    } else {
                        count++;
                        if (count == 1) {
                            temp = (String) t1_c3.getText();
                            btn_temp = t1_c3;
                        } else if (count == 2) {
                            btn_temp.setText(t1_c3.getText());
                            t1_c3.setText(temp);
                            t1_c3.setBackgroundResource(R.drawable.bg_btn_course_selector);
                            btn_temp.setBackgroundResource(R.drawable.bg_btn_course_selector);
                            count = 0;
                            btn_temp = null;
                            t1_c1_selected = false;
                            t1_c3_selected = false;
                            t2_c1_selected = false;
                            t3_c2_selected = false;
                            Toast toast = Toast.makeText(view.getContext(), "Roadmap has been successfully updated!" , Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                }

            }
        });
        t2_c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(view_selected) {
                    identifyCourse((String)t2_c1.getText());
                }
                if(switch_selected) {
                    t2_c1_selected = true;
                    t2_c1.setBackgroundResource(R.drawable.bg_btn_course_selected);

                    if (t2_c1_selected && t3_c2_selected) {
                        pb.setVisibility(View.VISIBLE);
                        count = 0;
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

                    } else {
                        count++;
                        if(count == 1) {
                            temp = (String)t2_c1.getText();
                            btn_temp = t2_c1;
                        } else if (count == 2) {
                            btn_temp.setText(t2_c1.getText());
                            t2_c1.setText(temp);
                            t2_c1.setBackgroundResource(R.drawable.bg_btn_course_selector);
                            btn_temp.setBackgroundResource(R.drawable.bg_btn_course_selector);
                            count = 0;
                            btn_temp = null;
                            t1_c1_selected = false;
                            t1_c3_selected = false;
                            t2_c1_selected = false;
                            t3_c2_selected = false;
                            Toast toast = Toast.makeText(view.getContext(), "Roadmap has been successfully updated!" , Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }


                }


            }
        });
        t2_c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view_selected) {
                    identifyCourse((String)t2_c2.getText());
                }
                if(switch_selected) {
                    t2_c2.setBackgroundResource(R.drawable.bg_btn_course_selected);
                    count++;
                    if(count == 1) {
                        temp = (String)t2_c2.getText();
                        btn_temp = t2_c2;
                    } else if (count == 2) {
                        btn_temp.setText(t2_c2.getText());
                        t2_c2.setText(temp);
                        t2_c2.setBackgroundResource(R.drawable.bg_btn_course_selector);
                        btn_temp.setBackgroundResource(R.drawable.bg_btn_course_selector);
                        count = 0;
                        btn_temp = null;
                        t1_c1_selected = false;
                        t1_c3_selected = false;
                        t2_c1_selected = false;
                        t3_c2_selected = false;
                        Toast toast = Toast.makeText(view.getContext(), "Roadmap has been successfully updated!" , Toast.LENGTH_LONG);
                        toast.show();
                    }
                }

            }
        });
        t2_c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view_selected) {
                    identifyCourse((String)t2_c3.getText());
                }
                if(switch_selected) {
                    t2_c3.setBackgroundResource(R.drawable.bg_btn_course_selected);
                    count++;
                    if(count == 1) {
                        temp = (String)t2_c3.getText();
                        btn_temp = t2_c3;
                    } else if (count == 2) {
                        btn_temp.setText(t2_c3.getText());
                        t2_c3.setText(temp);
                        t2_c3.setBackgroundResource(R.drawable.bg_btn_course_selector);
                        btn_temp.setBackgroundResource(R.drawable.bg_btn_course_selector);
                        count = 0;
                        btn_temp = null;
                        t1_c1_selected = false;
                        t1_c3_selected = false;
                        t2_c1_selected = false;
                        t3_c2_selected = false;
                        Toast toast = Toast.makeText(view.getContext(), "Roadmap has been successfully updated!" , Toast.LENGTH_LONG);
                        toast.show();
                    }
                }


            }
        });
        t3_c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view_selected) {
                    identifyCourse((String)t3_c1.getText());
                }
                if(switch_selected) {
                    t3_c1.setBackgroundResource(R.drawable.bg_btn_course_selected);
                    count++;
                    if(count == 1) {
                        temp = (String)t3_c1.getText();
                        btn_temp = t3_c1;
                    } else if (count == 2) {
                        btn_temp.setText(t3_c1.getText());
                        t3_c1.setText(temp);
                        t3_c1.setBackgroundResource(R.drawable.bg_btn_course_selector);
                        btn_temp.setBackgroundResource(R.drawable.bg_btn_course_selector);
                        count = 0;
                        btn_temp = null;
                        t1_c1_selected = false;
                        t1_c3_selected = false;
                        t2_c1_selected = false;
                        t3_c2_selected = false;
                        Toast toast = Toast.makeText(view.getContext(), "Roadmap has been successfully updated!" , Toast.LENGTH_LONG);
                        toast.show();
                    }
                }


            }
        });
        t3_c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(view_selected) {
                    identifyCourse((String)t3_c2.getText());
                }
                if(switch_selected) {
                    t3_c2_selected = true;
                    t3_c2.setBackgroundResource(R.drawable.bg_btn_course_selected);

                    if (t2_c1_selected && t3_c2_selected) {
                        pb.setVisibility(View.VISIBLE);
                        count = 0;
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

                    } else if(t1_c3_selected & t3_c2_selected) {
                        pb.setVisibility(View.VISIBLE);
                        count = 0;
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
                    } else if (t1_c1_selected && t3_c2_selected) {
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
                                        t1_c1_selected = false;
                                        t3_c2_selected = false;
                                        t1_c1.setBackgroundResource(R.drawable.bg_btn_course_selector);
                                        t3_c2.setBackgroundResource(R.drawable.bg_btn_course_selector);
                                        Toast toast = Toast.makeText(view.getContext(), "No changes are completed" , Toast.LENGTH_LONG);
                                        toast.show();
                                    }
                                });
                        // 显示
                        normalDialog.show();
                        count = 0;



                    } else {
                        count++;
                        if (count == 1) {
                            temp = (String) t3_c2.getText();
                            btn_temp = t3_c2;
                        } else if (count == 2) {
                            btn_temp.setText(t3_c2.getText());
                            t3_c2.setText(temp);
                            t3_c2.setBackgroundResource(R.drawable.bg_btn_course_selector);
                            btn_temp.setBackgroundResource(R.drawable.bg_btn_course_selector);
                            count = 0;
                            btn_temp = null;
                            t1_c1_selected = false;
                            t1_c3_selected = false;
                            t2_c1_selected = false;
                            t3_c2_selected = false;
                            Toast toast = Toast.makeText(view.getContext(), "Roadmap has been successfully updated!" , Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                }

            }
        });
        t3_c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view_selected) {
                    identifyCourse((String)t3_c3.getText());
                }
                if(switch_selected) {
                    t3_c3.setBackgroundResource(R.drawable.bg_btn_course_selected);
                    count++;
                    if(count == 1) {
                        temp = (String)t3_c3.getText();
                        btn_temp = t3_c3;
                    } else if (count == 2) {
                        btn_temp.setText(t3_c3.getText());
                        t3_c3.setText(temp);
                        t3_c3.setBackgroundResource(R.drawable.bg_btn_course_selector);
                        btn_temp.setBackgroundResource(R.drawable.bg_btn_course_selector);
                        count = 0;
                        btn_temp = null;
                        t1_c1_selected = false;
                        t1_c3_selected = false;
                        t2_c1_selected = false;
                        t3_c2_selected = false;
                        Toast toast = Toast.makeText(view.getContext(), "Roadmap has been successfully updated!" , Toast.LENGTH_LONG);
                        toast.show();
                    }
                }

            }
        });

        return view;
    }

    private void showLayoutDialog(String code, String name, int star_num, String needed, String t1, String t2, String t3, String URL) {
        View dialogView = LayoutInflater.from(mContext).inflate(R.layout.course_layout,null);
        TextView course_code = (TextView) dialogView.findViewById(R.id.course_code);
        TextView course_name = (TextView) dialogView.findViewById(R.id.course_name);
        ImageView star_1 = (ImageView) dialogView.findViewById(R.id.star_1);
        ImageView star_2 = (ImageView) dialogView.findViewById(R.id.star_2);
        ImageView star_3 = (ImageView) dialogView.findViewById(R.id.star_3);
        ImageView star_4 = (ImageView) dialogView.findViewById(R.id.star_4);
        ImageView star_5 = (ImageView) dialogView.findViewById(R.id.star_5);
        TextView needed_for = (TextView) dialogView.findViewById(R.id.needed_for);
        Button topic_1 = (Button) dialogView.findViewById(R.id.topic_1);
        Button topic_2 = (Button) dialogView.findViewById(R.id.topic_2);
        Button topic_3 = (Button) dialogView.findViewById(R.id.topic_3);
        TextView read_more = (TextView) dialogView.findViewById(R.id.read_more);

        course_code.setText(code);
        course_name.setText(name);
        if(star_num == 0) {
            star_1.setImageResource(R.drawable.empty_star);
            star_2.setImageResource(R.drawable.empty_star);
            star_3.setImageResource(R.drawable.empty_star);
            star_4.setImageResource(R.drawable.empty_star);
            star_5.setImageResource(R.drawable.empty_star);
        } else if(star_num == 1) {
            star_2.setImageResource(R.drawable.empty_star);
            star_3.setImageResource(R.drawable.empty_star);
            star_4.setImageResource(R.drawable.empty_star);
            star_5.setImageResource(R.drawable.empty_star);
        } else if(star_num == 2) {
            star_3.setImageResource(R.drawable.empty_star);
            star_4.setImageResource(R.drawable.empty_star);
            star_5.setImageResource(R.drawable.empty_star);
        } else if(star_num == 3) {
            star_4.setImageResource(R.drawable.empty_star);
            star_5.setImageResource(R.drawable.empty_star);
        } else if(star_num == 4) {
            star_5.setImageResource(R.drawable.empty_star);
        }
        needed_for.setText(needed);
        topic_1.setText(t1);
        topic_2.setText(t2);
        topic_3.setText(t3);

        course_web_activity.URL = URL;

        read_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, course_web_activity.class);
                mContext.startActivity(intent);
            }
        });

        final AlertDialog.Builder layoutDialog = new AlertDialog.Builder(mContext);
        layoutDialog.setView(dialogView);



        layoutDialog.create().show();
    }


    private void identifyCourse(String course_name) {
        String code, name, needed, t1, t2, t3, URL;
        int star_num;

        if(course_name.equals("INFS1602")) {
            code = "INFS1602";
            name = "Digital Transformation in Business";
            needed = "Needed for: INFS2603, INFS2621, INFS3603, INFS3617, INFS2631, INFS3632";
            t1 = "IS/IT";
            t2 = "EA";
            t3 = "CRM";
            star_num = 4;
            URL = "https://www.handbook.unsw.edu.au/undergraduate/courses/2019/INFS1602/";
        } else if(course_name.equals("INFS1603")) {
            code = "INFS1603";
            name = "Intro to Business Databases";
            needed = "Needed for: INFS2603, INFS2608";
            t1 = "Data";
            t2 = "SQL";
            t3 = "Database";
            star_num = 3;
            URL = "https://www.handbook.unsw.edu.au/undergraduate/courses/2019/INFS1603/";
        } else if(course_name.equals("INFS2608")) {
            code = "INFS2608";
            name = "DB Mgmt & BD Infrastructures";
            needed = "Needed for: INFS3634";
            t1 = "Hadoop";
            t2 = "Big Data";
            t3 = "Database";
            star_num = 3;
            URL = "https://www.handbook.unsw.edu.au/undergraduate/courses/2019/INFS2608/";
        } else if(course_name.equals("INFS1609")) {
            code = "INFS1609";
            name = "Fundamentals of Business Programming";
            needed = "Needed for: INFS2605";
            t1 = "Java";
            t2 = "OOP";
            t3 = "Algorithm";
            star_num = 3;
            URL = "https://www.handbook.unsw.edu.au/undergraduate/courses/2019/INFS1609/";
        } else if(course_name.equals("INFS2621")) {
            code = "INFS2621";
            name = "Enterprise Systems";
            needed = "Needed for: N/A";
            t1 = "SAS";
            t2 = "ERP";
            t3 = "SCM";
            star_num = 2;
            URL = "https://www.handbook.unsw.edu.au/undergraduate/courses/2019/INFS2621/";
        } else {
            code = "MGMT1001";
            name = "Managing Organisation & People";
            needed = "Needed for: MGMT2001, MGMT2010, MGMT2725";
            t1 = "Strategy";
            t2 = "PORTER 5";
            t3 = "SWOT";
            star_num = 5;
            URL = "https://www.handbook.unsw.edu.au/undergraduate/courses/2019/MGMT1001/";
        }
        showLayoutDialog(code, name, star_num, needed, t1, t2, t3, URL);

    }



}