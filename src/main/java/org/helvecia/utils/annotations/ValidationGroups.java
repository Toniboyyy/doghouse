package org.helvecia.utils.annotations;

import jakarta.validation.groups.Default;

public interface ValidationGroups {
    interface Create extends Default { 
    }
    interface Update extends Default { 
    }
}