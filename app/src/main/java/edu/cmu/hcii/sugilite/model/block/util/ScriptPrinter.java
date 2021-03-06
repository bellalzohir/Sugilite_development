package edu.cmu.hcii.sugilite.model.block.util;

import edu.cmu.hcii.sugilite.model.block.SugiliteBlock;
import edu.cmu.hcii.sugilite.model.block.SugiliteConditionBlock;
import edu.cmu.hcii.sugilite.model.block.SugiliteStartingBlock;
import edu.cmu.hcii.sugilite.model.block.SugiliteOperationBlock;
import edu.cmu.hcii.sugilite.model.block.operation.special_operation.SugiliteSpecialOperationBlock;

/**
 * @author toby
 * @date 3/12/18
 * @time 9:57 PM
 */
public class ScriptPrinter {
    public static String getStringScript(SugiliteBlock block){
        String results = "";
        if(block != null) {
            results += block.toString() + "\n";
        }
        else{
            return results + "(SUGILITE_END)";
        }
        if(block instanceof SugiliteStartingBlock){
            return results + getStringScript(((SugiliteStartingBlock) block).getNextBlock());
        }
        if(block instanceof SugiliteOperationBlock){
            return results + getStringScript(((SugiliteOperationBlock) block).getNextBlock());
        }
        if(block instanceof SugiliteSpecialOperationBlock){
            return results + getStringScript(((SugiliteSpecialOperationBlock) block).getNextBlock());
        }
        if(block instanceof SugiliteConditionBlock){
            return results + getStringScript(((SugiliteConditionBlock) block).getNextBlock());
        }
        return "ERROR";
    }
}
