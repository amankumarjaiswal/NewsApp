package com.amankj.news.view;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import com.amankj.news.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4ClassRunner.class)
public class NewsListViewActivityTest {

    @Rule
    public ActivityTestRule<NewsListViewActivity> activityTestRule = new ActivityTestRule<>(NewsListViewActivity.class);

    @Test
    public void testViews() {
        onView(withText("News")).check(matches(isDisplayed()));
        onView(withId(R.id.news_list_view)).check(matches(isDisplayed()));
    }
}