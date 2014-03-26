package com.inkapplications.android.navigation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import java.util.Map;

/**
 *
 */
public class FragmentNavigator
{
    private FragmentManager manager;
    private Map<Class, Fragment> fragments;
    private Class defaultFragment;
    private int fragmentContainer;

    public FragmentNavigator(
            FragmentManager manager,
            int fragmentContainer,
            Map<Class, Fragment> fragments,
            Class defaultFragment
    ) {
        this.manager = manager;
        this.fragments = fragments;
        this.fragmentContainer = fragmentContainer;
        this.defaultFragment = defaultFragment;
    }

    public void showFragment(Class target)
    {
        FragmentTransaction transaction = this.manager.beginTransaction();
        Fragment targetFragment = this.fragments.get(target);
        transaction.replace(this.fragmentContainer, targetFragment);
        transaction.commit();
    }

    public void showDefaultFragment()
    {
        this.showFragment(this.defaultFragment);
    }

    final public Class getDefaultFragment()
    {
        return this.defaultFragment;
    }
}
