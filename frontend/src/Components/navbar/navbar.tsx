import './navbar.css';
import React from 'react';
import {ReactComponent as GitHubIcon} from 'assets/img/Vector.svg';


function navbar() {
    return (
        <>
            <header >
                <nav className='container'>
                    <div className='dsmovie-nav-content'>
                        <h1>DsMovie</h1>
                        <a href="https://github.com/luisfsm/dsmovie" target="_blank" rel='noreferrer' className='text-decorator'>

                            <div className='dsmovie-contact-container'>
                                <GitHubIcon />
                                <p className="dsmovie-contact-link">/LuisFsm</p>
                            </div>

                        </a>
                    </div>
                </nav>
            </header>

        </>
    )
}

export default navbar;
