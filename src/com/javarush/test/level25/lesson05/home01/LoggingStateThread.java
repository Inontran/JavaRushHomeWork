package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Inontran on 24.10.2016.
 */
public class LoggingStateThread extends Thread
{
    private Thread target;

    public LoggingStateThread(Thread target)
    {
        this.target = target;
        System.out.println(target.getState());
    }

    @Override
    public void run()
    {
        Thread.State state = target.getState();
        System.out.println(state);
        while(state != State.TERMINATED)
        {
            if (state != target.getState())
            {
                state = target.getState();
                System.out.println(state);
            }
        }
        interrupt();
    }
}
