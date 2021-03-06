/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javiermoreno.awsdemos.awarsconsole;

import com.javiermoreno.awsdemos.awarsconsole.domain.ConflictStats;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ciberado
 */
public class StatsServiceImplMem implements StatsService {
   
    private Map<String, ConflictStats> stats = new HashMap<String, ConflictStats>();

    @Override
    public void updateConflictStats(String warId, String opponentWarId,  
                                    String instanceId, String instanceType, double requestPerSecond) {
        String attacker = opponentWarId;
        String defender = warId;
        String conflictName = attacker + "_" + defender;
        ConflictStats conflictStats = stats.get(conflictName);
        if (conflictStats == null) {
            conflictStats = new ConflictStats(attacker, defender);
            stats.put(conflictName, conflictStats);
        }
        conflictStats.updateStats(instanceId, instanceType, requestPerSecond);
        System.out.println("LOG: Stats size: " + stats.size());
    }
    

    @Override
    public Map<String, ConflictStats> getConflictStats() {
        return stats;
    }

    
    
    
    
    
    
}
